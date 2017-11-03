# videotop

Trabalho de Tópicos Especiais II - Universidade Federal de Viçosa

  A segurança dos dados é de vital importância em ambientes de organizações em
geral. Certas informações devem possuir nı́veis de segurança mais elevados que outras
por serem mais confidenciais e não podem ser vistas por qualquer usuário. O con-
trole de acesso as informações são o foco deste trabalho. Para isso, uma aplicação foi
desenvolvida para realizar o devido tratamento das autorizações dos usuários.
O trabalho deu enfoque na propriedade de segurança simples, a qual diz que não é
autorizado a um sujeito S o acesso de leitura a um objeto O, a não ser que:
                          classe (S) >= classe (O).
  Por isso a parte de segurança de acesso de leitura está mais fortemente presente
e relacionada com o conceito de controle de acesso obrigatório visto na disciplina. A
pouca representação da propriedade estrela será explicada em seções posteriores.
O contexto escolhido para o trabalho foi o de uma vı́deo locadora, a VideoTOP.
Nessa vı́deo locadora trabalham um gerente, vários funcionários e possui vários clientes
com seus dependentes. A escolha desse contexto se deve ao fato de que uma vı́deo
locadora possui diferentes tipos de usuários com distintas permissões. Um dependente
menor de idade, por exemplo, não pode acessar vı́deos que não são da sua faixa etária.
Outro exemplo é que um atendente não pode ver informações de outros funcionários.
Essa escolha se tornou um ambiente mais simples de simular o sistema de controle de
acesso obrigatório.
  Com esse sistema de segurança baseado em classes, os usuários da aplicação estão
sendo ”iludidos” de que estão vendo todas as tuplas e conteúdo do banco, quando na
verdade estão vendo apenas aquelas permitidas pela sua classe de segurança.
