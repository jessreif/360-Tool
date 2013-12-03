SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `360feedbacksurvey` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `360feedbacksurvey` ;

-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`team` (
  `teamid` INT NOT NULL AUTO_INCREMENT,
  `teamname` VARCHAR(45) NULL,
  `teamdescription` VARCHAR(100) NULL,
  `teamcreatetime` TIMESTAMP NULL,
  PRIMARY KEY (`teamid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`admin` (
  `adminid` INT NOT NULL AUTO_INCREMENT,
  `adminntlogin` VARCHAR(45) NULL,
  `adminlastlogin` TIMESTAMP NULL,
  `adminright` INT NULL,
  `adminemail` VARCHAR(45) NULL,
  `adminphone` VARCHAR(45) NULL,
  `admindescription` VARCHAR(100) NULL,
  PRIMARY KEY (`adminid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`member` (
  `memberid` INT NOT NULL AUTO_INCREMENT,
  `memberntlogin` VARCHAR(45) NULL,
  `memberrole` INT NULL,
  `membername` VARCHAR(45) NULL,
  `managernt` VARCHAR(45) NULL,
  `managername` VARCHAR(45) NULL,
  `team_teamid` INT NOT NULL,
  PRIMARY KEY (`memberid`),
  INDEX `fk_member_team1_idx` (`team_teamid` ASC),
  CONSTRAINT `fk_member_team1`
    FOREIGN KEY (`team_teamid`)
    REFERENCES `360feedbacksurvey`.`team` (`teamid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`surveytemplate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`surveytemplate` (
  `surveytemplateid` INT NOT NULL AUTO_INCREMENT,
  `surveytemplatetitle` VARCHAR(45) NULL,
  `surveytemplatedescription` VARCHAR(45) NULL,
  `admin_adminid` INT NOT NULL,
  PRIMARY KEY (`surveytemplateid`),
  INDEX `fk_surveytemplate_admin_idx` (`admin_adminid` ASC),
  CONSTRAINT `fk_surveytemplate_admin`
    FOREIGN KEY (`admin_adminid`)
    REFERENCES `360feedbacksurvey`.`admin` (`adminid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`question` (
  `questionid` INT NOT NULL AUTO_INCREMENT,
  `questioncontent` VARCHAR(200) NULL,
  `questioncount` INT NULL,
  `surveytemplate_surveytemplateid` INT NOT NULL,
  PRIMARY KEY (`questionid`),
  INDEX `fk_question_surveytemplate1_idx` (`surveytemplate_surveytemplateid` ASC),
  CONSTRAINT `fk_question_surveytemplate1`
    FOREIGN KEY (`surveytemplate_surveytemplateid`)
    REFERENCES `360feedbacksurvey`.`surveytemplate` (`surveytemplateid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`survey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`survey` (
  `surveyid` INT NOT NULL,
  `surveystarttime` TIMESTAMP NULL,
  `surveyfinishtime` TIMESTAMP NULL,
  `surveytemplate_surveytemplateid` INT NOT NULL,
  `team_teamid` INT NOT NULL,
  PRIMARY KEY (`surveyid`),
  INDEX `fk_survey_surveytemplate1_idx` (`surveytemplate_surveytemplateid` ASC),
  INDEX `fk_survey_team1_idx` (`team_teamid` ASC),
  CONSTRAINT `fk_survey_surveytemplate1`
    FOREIGN KEY (`surveytemplate_surveytemplateid`)
    REFERENCES `360feedbacksurvey`.`surveytemplate` (`surveytemplateid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_survey_team1`
    FOREIGN KEY (`team_teamid`)
    REFERENCES `360feedbacksurvey`.`team` (`teamid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`membersurvey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`membersurvey` (
  `membersurveyid` INT NOT NULL AUTO_INCREMENT,
  `membersurveystatus` INT NULL,
  `membersurveyfinishtime` TIMESTAMP NULL,
  `member_memberid` INT NOT NULL,
  `member_memberid_target` INT NOT NULL,
  `survey_surveyid` INT NOT NULL,
  PRIMARY KEY (`membersurveyid`),
  INDEX `fk_membersurvey_member1_idx` (`member_memberid` ASC),
  INDEX `fk_membersurvey_member2_idx` (`member_memberid_target` ASC),
  INDEX `fk_membersurvey_survey1_idx` (`survey_surveyid` ASC),
  CONSTRAINT `fk_membersurvey_member1`
    FOREIGN KEY (`member_memberid`)
    REFERENCES `360feedbacksurvey`.`member` (`memberid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membersurvey_member2`
    FOREIGN KEY (`member_memberid_target`)
    REFERENCES `360feedbacksurvey`.`member` (`memberid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membersurvey_survey1`
    FOREIGN KEY (`survey_surveyid`)
    REFERENCES `360feedbacksurvey`.`survey` (`surveyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `360feedbacksurvey`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `360feedbacksurvey`.`answer` (
  `answerid` INT NOT NULL AUTO_INCREMENT,
  `answerscore` INT NULL,
  `membersurvey_membersurveyid` INT NOT NULL,
  `question_questionid` INT NOT NULL,
  PRIMARY KEY (`answerid`),
  INDEX `fk_answer_membersurvey1_idx` (`membersurvey_membersurveyid` ASC),
  INDEX `fk_answer_question1_idx` (`question_questionid` ASC),
  CONSTRAINT `fk_answer_membersurvey1`
    FOREIGN KEY (`membersurvey_membersurveyid`)
    REFERENCES `360feedbacksurvey`.`membersurvey` (`membersurveyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_question1`
    FOREIGN KEY (`question_questionid`)
    REFERENCES `360feedbacksurvey`.`question` (`questionid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
