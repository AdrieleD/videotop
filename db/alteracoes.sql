-- -----------------------------  TABELA ator -------------------------------------- 

ALTER TABLE `videotopdb`.`ator` 
CHANGE COLUMN `idatorC` `idatorC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomeC` `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `dataNascimentoC` `dataNascimentoC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `atorTC` `atorTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA dependente -------------------------------------- 
ALTER TABLE `videotopdb`.`dependente` 
DROP FOREIGN KEY `fk_dependente_usuario1`;
ALTER TABLE `videotopdb`.`dependente` 
CHANGE COLUMN `iddependenteC` `iddependenteC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `cpfC` `cpfC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomeC` `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `dataNascimentoC` `dataNascimentoC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `dependenteTC` `dependenteTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`dependente` 
ADD CONSTRAINT `fk_dependente_usuario1`
  FOREIGN KEY (`cpf` , `cpfC`)
  REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA emprestimo -------------------------------------- 
ALTER TABLE `videotopdb`.`emprestimo` 
DROP FOREIGN KEY `fk_emprestimo_fita1`,
DROP FOREIGN KEY `fk_emprestimo_usuario1`;
ALTER TABLE `videotopdb`.`emprestimo` 
CHANGE COLUMN `idfitaC` `idfitaC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `usuario_cpfC` `cpfC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `dataEmprestimoC` `dataEmprestimoC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `dataDevolucaoC` `dataDevolucaoC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `valorC` `valorC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `emprestimoTC` `emprestimoTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`emprestimo` 
ADD CONSTRAINT `fk_emprestimo_fita1`
  FOREIGN KEY (`idfita` , `idfitaC`)
  REFERENCES `videotopdb`.`fita` (`idfita` , `idfitaC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_emprestimo_usuario1`
  FOREIGN KEY (`cpf` , `cpfC`)
  REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA estudio -------------------------------------- 
ALTER TABLE `videotopdb`.`estudio` 
CHANGE COLUMN `idestudioC` `idestudioC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomeC` `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `sedeC` `sedeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `estudioTC` `estudioTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA filme -------------------------------------- 
ALTER TABLE `videotopdb`.`filme` 
CHANGE COLUMN `idFilmeC` `idFilmeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `tituloC` `tituloC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `filmeTC` `filmeTC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
ADD COLUMN `ano` CHAR(4) NOT NULL AFTER `tituloC`,
ADD COLUMN `anoC` VARCHAR(2) NOT NULL DEFAULT 'U' AFTER `ano`;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA filme_tem_ator -------------------------------------- 
ALTER TABLE `videotopdb`.`filme_tem_ator` 
DROP FOREIGN KEY `fk_filme_has_ator_ator1`,
DROP FOREIGN KEY `fk_filme_has_ator_filme1`;
ALTER TABLE `videotopdb`.`filme_tem_ator` 
CHANGE COLUMN `idFilmeC` `idFilmeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `idatorC` `idatorC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomePersonagemC` `nomePersonagemC` VARCHAR(2) NULL DEFAULT 'U' ,
CHANGE COLUMN `filme_tem_atorTC` `filme_tem_atorTC` VARCHAR(2) NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`filme_tem_ator` 
ADD CONSTRAINT `fk_filme_has_ator_ator1`
  FOREIGN KEY (`idator` , `idatorC`)
  REFERENCES `videotopdb`.`ator` (`idator` , `idatorC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_filme_has_ator_filme1`
  FOREIGN KEY (`idfilme` , `idFilmeC`)
  REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA filme_tem_estudio -------------------------------------- 
ALTER TABLE `videotopdb`.`filme_tem_estudio` 
DROP FOREIGN KEY `fk_filme_has_estudio_estudio1`,
DROP FOREIGN KEY `fk_filme_has_estudio_filme1`;
ALTER TABLE `videotopdb`.`filme_tem_estudio` 
CHANGE COLUMN `idFilmeC` `idFilmeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `idestudioC` `idestudioC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`filme_tem_estudio` 
ADD CONSTRAINT `fk_filme_has_estudio_estudio1`
  FOREIGN KEY (`idestudio` , `idestudioC`)
  REFERENCES `videotopdb`.`estudio` (`idestudio` , `idestudioC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_filme_has_estudio_filme1`
  FOREIGN KEY (`idfilme` , `idFilmeC`)
  REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA filme_tem_genero -------------------------------------- 
ALTER TABLE `videotopdb`.`filme_tem_genero` 
DROP FOREIGN KEY `fk_filme_has_genero_filme1`,
DROP FOREIGN KEY `fk_filme_has_genero_genero1`;
ALTER TABLE `videotopdb`.`filme_tem_genero` 
CHANGE COLUMN `idFilmeC` `idFilmeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `idgeneroC` `idgeneroC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`filme_tem_genero` 
ADD CONSTRAINT `fk_filme_has_genero_filme1`
  FOREIGN KEY (`idfilme` , `idFilmeC`)
  REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_filme_has_genero_genero1`
  FOREIGN KEY (`idgenero` , `idgeneroC`)
  REFERENCES `videotopdb`.`genero` (`idgenero` , `idgeneroC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA fita -------------------------------------- 
ALTER TABLE `videotopdb`.`fita` 
DROP FOREIGN KEY `fk_fita_filme1`;
ALTER TABLE `videotopdb`.`fita` 
CHANGE COLUMN `idfitaC` `idfitaC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `idFilmeC` `idFilmeC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`fita` 
ADD CONSTRAINT `fk_fita_filme1`
  FOREIGN KEY (`idfilme` , `idFilmeC`)
  REFERENCES `videotopdb`.`filme` (`idfilme` , `idFilmeC`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA funcionario -------------------------------------- 
ALTER TABLE `videotopdb`.`funcionario` 
DROP FOREIGN KEY `fk_funcionario_usuario1`;
ALTER TABLE `videotopdb`.`funcionario` 
CHANGE COLUMN `usuario_cpfC` `cpfC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `salarioC` `salarioC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `funcionarioTC` `funcionarioTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`funcionario` 
ADD CONSTRAINT `fk_funcionario_usuario1`
  FOREIGN KEY (`cpf` , `cpfC`)
  REFERENCES `videotopdb`.`usuario` (`cpf` , `cpfC`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA genero -------------------------------------- 
ALTER TABLE `videotopdb`.`genero` 
CHANGE COLUMN `idgeneroC` `idgeneroC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomeC` `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `descricao` `descricao` VARCHAR(300) NOT NULL ,
CHANGE COLUMN `descricaoC` `descricaoC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `generoTC` `generoTC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
-- ----------------------------------------------------------------------------------


-- -----------------------------  TABELA tipoUsuario -------------------------------------- 
ALTER TABLE `videotopdb`.`tipoUsuario` 
CHANGE COLUMN `idtipoUsuarioC` `idtipoUsuarioC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `nomeC` `nomeC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `classeC` `classeC` VARCHAR(2) NOT NULL DEFAULT 'AS' ,
CHANGE COLUMN `tipoUsuarioTC` `tipoUsuarioTC` VARCHAR(2) NULL DEFAULT 'U' ;

ALTER TABLE `videotopdb`.`tipoUsuario` 
CHANGE COLUMN `idtipoUsuario` `idtipousuario` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `idtipoUsuarioC` `idtipousuarioC` VARCHAR(2) NOT NULL DEFAULT 'U' ;

-- ----------------------------------------------------------------------------------

-- -----------------------------  TABELA usuario -------------------------------------- 
ALTER TABLE `videotopdb`.`usuario` 
DROP FOREIGN KEY `fk_usuario_tipoUsuario1`;
ALTER TABLE `videotopdb`.`usuario` 
CHANGE COLUMN `cpfC` `cpfC` VARCHAR(2) NOT NULL DEFAULT 'U' ,
CHANGE COLUMN `idtipoUsuario` `idtipousuario` INT(11) NOT NULL ,
CHANGE COLUMN `idtipoUsuarioC` `idtipousuarioC` VARCHAR(2) NOT NULL DEFAULT 'U' ;
ALTER TABLE `videotopdb`.`usuario` 
ADD CONSTRAINT `fk_usuario_tipoUsuario1`
  FOREIGN KEY (`idtipousuario` , `idtipousuarioC`)
  REFERENCES `videotopdb`.`tipoUsuario` (`idtipousuario` , `idtipousuarioC`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

-- ----------------------------------------------------------------------------------
