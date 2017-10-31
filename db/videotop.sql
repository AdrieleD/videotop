SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `videotopdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `videotopdb` ;

-- -----------------------------------------------------
-- Table `videotopdb`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`filme` (
  `idfilme` INT NOT NULL AUTO_INCREMENT,
  `idFilmeC` VARCHAR(2) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `tituloC` VARCHAR(2) NOT NULL,
  `filmeTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idfilme`, `idFilmeC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`fita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`fita` (
  `idfita` INT NOT NULL AUTO_INCREMENT,
  `idfitaC` VARCHAR(2) NOT NULL,
  `idfilme` INT NOT NULL,
  `idFilmeC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idfita`, `idfitaC`),
  INDEX `fk_fita_filme1_idx` (`idfilme` ASC, `idFilmeC` ASC),
  CONSTRAINT `fk_fita_filme1`
    FOREIGN KEY (`idfilme` , `idFilmeC`)
    REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`ator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`ator` (
  `idator` INT NOT NULL AUTO_INCREMENT,
  `idatorC` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `dataNascimentoC` VARCHAR(2) NOT NULL,
  `atorTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idator`, `idatorC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`filme_tem_ator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`filme_tem_ator` (
  `idfilme` INT NOT NULL,
  `idFilmeC` VARCHAR(2) NOT NULL,
  `idator` INT NOT NULL,
  `idatorC` VARCHAR(2) NOT NULL,
  `nomePersonagem` VARCHAR(45) NOT NULL,
  `nomePersonagemC` VARCHAR(2) NULL,
  `filme_tem_atorTC` VARCHAR(2) NULL,
  PRIMARY KEY (`idfilme`, `idFilmeC`, `idator`, `idatorC`),
  INDEX `fk_filme_has_ator_ator1_idx` (`idator` ASC, `idatorC` ASC),
  INDEX `fk_filme_has_ator_filme1_idx` (`idfilme` ASC, `idFilmeC` ASC),
  CONSTRAINT `fk_filme_has_ator_filme1`
    FOREIGN KEY (`idfilme` , `idFilmeC`)
    REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_filme_has_ator_ator1`
    FOREIGN KEY (`idator` , `idatorC`)
    REFERENCES `videotopdb`.`ator` (`idator` , `idatorC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`estudio` (
  `idestudio` INT NOT NULL AUTO_INCREMENT,
  `idestudioC` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL,
  `sede` VARCHAR(45) NOT NULL,
  `sedeC` VARCHAR(2) NOT NULL,
  `estudioTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idestudio`, `idestudioC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`filme_tem_estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`filme_tem_estudio` (
  `idfilme` INT NOT NULL,
  `idFilmeC` VARCHAR(2) NOT NULL,
  `idestudio` INT NOT NULL,
  `idestudioC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idfilme`, `idFilmeC`, `idestudio`, `idestudioC`),
  INDEX `fk_filme_has_estudio_estudio1_idx` (`idestudio` ASC, `idestudioC` ASC),
  INDEX `fk_filme_has_estudio_filme1_idx` (`idfilme` ASC, `idFilmeC` ASC),
  CONSTRAINT `fk_filme_has_estudio_filme1`
    FOREIGN KEY (`idfilme` , `idFilmeC`)
    REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_filme_has_estudio_estudio1`
    FOREIGN KEY (`idestudio` , `idestudioC`)
    REFERENCES `videotopdb`.`estudio` (`idestudio` , `idestudioC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`genero` (
  `idgenero` INT NOT NULL AUTO_INCREMENT,
  `idgeneroC` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `descricaoC` VARCHAR(2) NOT NULL,
  `generoTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idgenero`, `idgeneroC`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`filme_tem_genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`filme_tem_genero` (
  `idfilme` INT NOT NULL,
  `idFilmeC` VARCHAR(2) NOT NULL,
  `idgenero` INT NOT NULL,
  `idgeneroC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idfilme`, `idFilmeC`, `idgenero`, `idgeneroC`),
  INDEX `fk_filme_has_genero_genero1_idx` (`idgenero` ASC, `idgeneroC` ASC),
  INDEX `fk_filme_has_genero_filme1_idx` (`idfilme` ASC, `idFilmeC` ASC),
  CONSTRAINT `fk_filme_has_genero_filme1`
    FOREIGN KEY (`idfilme` , `idFilmeC`)
    REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_filme_has_genero_genero1`
    FOREIGN KEY (`idgenero` , `idgeneroC`)
    REFERENCES `videotopdb`.`genero` (`idgenero` , `idgeneroC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`tipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`tipoUsuario` (
  `idtipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `idtipoUsuarioC` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL,
  `classe` VARCHAR(45) NOT NULL,
  `classeC` VARCHAR(2) NOT NULL,
  `tipoUsuarioTC` VARCHAR(2) NULL,
  PRIMARY KEY (`idtipoUsuario`, `idtipoUsuarioC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`usuario` (
  `cpf` CHAR(11) NOT NULL,
  `cpfC` VARCHAR(2) NOT NULL DEFAULT 'AS',
  `senha` VARCHAR(45) NOT NULL,
  `senhaC` VARCHAR(2) NOT NULL DEFAULT 'AS',
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U',
  `dataNascimento` DATE NOT NULL,
  `dataNascimentoC` VARCHAR(2) NOT NULL DEFAULT 'U',
  `logradouro` VARCHAR(45) NOT NULL,
  `logradouroC` VARCHAR(2) NOT NULL DEFAULT 'S',
  `numero` VARCHAR(10) NOT NULL,
  `numeroC` VARCHAR(2) NOT NULL DEFAULT 'S',
  `bairro` VARCHAR(45) NOT NULL,
  `bairroC` VARCHAR(2) NOT NULL DEFAULT 'S',
  `cep` VARCHAR(8) NOT NULL,
  `cepC` VARCHAR(2) NOT NULL DEFAULT 'S',
  `usuarioTC` VARCHAR(2) NOT NULL DEFAULT 'U',
  `telefone` VARCHAR(9) NOT NULL,
  `telefoneC` VARCHAR(2) NOT NULL DEFAULT 'S',
  `idtipoUsuario` INT NOT NULL,
  `idtipoUsuarioC` VARCHAR(2) NOT NULL DEFAULT 'U',
  PRIMARY KEY (`cpf`, `cpfC`),
  INDEX `fk_usuario_tipoUsuario1_idx` (`idtipoUsuario` ASC, `idtipoUsuarioC` ASC),
  CONSTRAINT `fk_usuario_tipoUsuario1`
    FOREIGN KEY (`idtipoUsuario` , `idtipoUsuarioC`)
    REFERENCES `videotopdb`.`tipoUsuario` (`idtipoUsuario` , `idtipoUsuarioC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`funcionario` (
  `cpf` CHAR(11) NOT NULL,
  `usuario_cpfC` VARCHAR(2) NOT NULL,
  `salario` FLOAT NOT NULL,
  `salarioC` VARCHAR(2) NOT NULL,
  `funcionarioTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`cpf`, `usuario_cpfC`),
  CONSTRAINT `fk_funcionario_usuario1`
    FOREIGN KEY (`cpf` , `usuario_cpfC`)
    REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`dependente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`dependente` (
  `iddependente` INT NOT NULL AUTO_INCREMENT,
  `iddependenteC` VARCHAR(2) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `cpfC` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nomeC` VARCHAR(2) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `dataNascimentoC` VARCHAR(2) NOT NULL,
  `dependenteTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`iddependente`, `iddependenteC`, `cpf`, `cpfC`),
  INDEX `fk_dependente_usuario1_idx` (`cpf` ASC, `cpfC` ASC),
  CONSTRAINT `fk_dependente_usuario1`
    FOREIGN KEY (`cpf` , `cpfC`)
    REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `videotopdb`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videotopdb`.`emprestimo` (
  `idfita` INT NOT NULL,
  `idfitaC` VARCHAR(2) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `usuario_cpfC` VARCHAR(2) NOT NULL,
  `dataEmprestimo` DATE NOT NULL,
  `dataEmprestimoC` VARCHAR(2) NOT NULL,
  `dataDevolucao` DATE NOT NULL,
  `dataDevolucaoC` VARCHAR(2) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `valorC` VARCHAR(2) NOT NULL,
  `emprestimoTC` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idfita`, `idfitaC`, `cpf`, `usuario_cpfC`),
  INDEX `fk_emprestimo_fita1_idx` (`idfita` ASC, `idfitaC` ASC),
  INDEX `fk_emprestimo_usuario1_idx` (`cpf` ASC, `usuario_cpfC` ASC),
  CONSTRAINT `fk_emprestimo_fita1`
    FOREIGN KEY (`idfita` , `idfitaC`)
    REFERENCES `videotopdb`.`fita` (`idfita` , `idfitaC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_emprestimo_usuario1`
    FOREIGN KEY (`cpf` , `usuario_cpfC`)
    REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
