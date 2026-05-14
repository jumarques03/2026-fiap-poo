# Projeto FiapRide - Júlia Souza Marques

## Informações do Aluno

- **Nome:** Júlia Souza Marques
- **RM:** 565010
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** @jumarques03

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide** (aplicativo de mobilidade urbana).

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** "**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`?

**Pense:** E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?"

**Resposta:**
Criar uma classe Passageiro é fundamental para estabelecer um molde único que encapsula tanto as características (atributos) quanto os comportamentos (métodos) de um usuário, garantindo organização e padronização. Se utilizássemos variáveis soltas para um milhão de usuários, o código se tornaria um emaranhado impossível de gerenciar, propenso a erros de digitação e duplicação de lógica. A classe resolve esse problema através da instanciabilidade: com apenas uma definição, o sistema pode criar milhões de objetos distintos na memória, cada um mantendo seu próprio estado de forma independente. Além disso, a classe facilita a manutenção e a escalabilidade, pois qualquer alteração na estrutura do passageiro é feita em um único lugar e replicada automaticamente para todos os registros do sistema.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, porque dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?

**Resposta:**
A utilização de métodos como adicionarSaldo(valor) é uma prática fundamental para proteger as regras de negócio da aplicação, pois permite que o objeto valide os dados antes de alterar seu estado interno. Ao permitir que um programador altere o saldo diretamente, a startup de mobilidade correria o risco de aceitar valores inconsistentes, como depósitos negativos ou transações sem fundos suficientes, o que comprometeria a inteligência e a segurança do software. Portanto, os métodos funcionam como motores que garantem que as ações do objeto ocorram apenas sob condições válidas, impedindo que o estado do sistema se torne instável ou fraudulento.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

_Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?_

**Resposta:**
O encapsulamento visa esconder os detalhes internos e proteger os dados sensíveis de um objeto através de modificadores de acesso como o private. Manter um atributo público é perigoso porque permite que qualquer classe externa altere o dado original sem controle, enquanto o método get público fornece apenas uma cópia para leitura, preservando a integridade da informação.

---

### Aula 4 - Construtores

**Pergunta:** Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito importantes:

> 1. Nós **não** criamos o método `setModelo()`.
> 2. O `setPlaca()` foi criado como **privado**, e criamos um método público chamado `atualizarPlaca()` para acessá-lo.
> Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo' automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?

_Dica: Pense sobre o que pode ou não mudar fisicamente em um carro, e a diferença entre "alterar um dado no banco" e "executar um processo real no Detran"._

**Resposta:**
Gerar todos os métodos de acesso automaticamente é um erro porque ignora a imutabilidade de certas características reais, por exemplo, o modelo de um carro não muda após fabricado, logo, não deve possuir um setModelo(). Ao tornar o setPlaca() privado e criar um método público atualizarPlaca(), o sistema obriga que qualquer alteração passe por uma lógica de validação específica que simula processos reais, como uma atualização no Detran. Essas decisões arquitetônicas protegem o sistema contra fraudes e falhas lógicas, garantindo que o objeto nasça e permaneça em um estado válido conforme as regras do domínio.

---

### Aula 5 - Associação

**Pergunta:** No construtor da `Viagem`, nós exigimos o objeto inteiro (`Passageiro solicitante`). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (`String nomeDoPassageiro`) em vez do objeto todo?

_Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?_

**Resposta:**
Exigir o objeto completo via associação permite que a classe Viagem navegue entre os objetos e acesse comportamentos complexos, como verificar o saldo real ou realizar pagamentos. Se a viagem possuísse apenas uma String com o nome, ela seria incapaz de interagir com as finanças do passageiro ao final da corrida, pois não teria uma referência direta ao objeto que gerencia o dinheiro. A passagem por referência garante que a viagem enxergue atualizações em tempo real no estado do passageiro, permitindo uma arquitetura onde os objetos "conversam" e executam processos de negócio integrados.

---

### Aula 6 - Herança

**Pergunta:** No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de `Carro` NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.

Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?

**Resposta:**
O Java impede o acesso direto a atributos privados da superclasse para blindar o princípio do encapsulamento, garantindo que a "mãe" continue sendo a única responsável por gerir a integridade de seus próprios dados. Mesmo que o carro herde características do veículo, ele deve usar métodos como super() ou setters públicos para interagir com esses dados, o que assegura que as validações originais não sejam ignoradas pela classe filha. Essa restrição protege o sistema contra o acoplamento desordenado e mantém a consistência da árvore genealógica, onde a especialização não pode violar as regras de acesso da generalização.

---

### Aula 7 - Polimorfismo

**Pergunta:** No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?

**Resposta:**
O contrato deve existir na classe mãe para que o compilador reconheça o método durante chamadas polimórficas em listas genéricas, como em um loop que percorre diversos tipos de veículos. Sem a declaração do método calcularAutonomia() na base, o Java não permitiria a chamada do comando para um objeto tratado como Veiculo, mesmo que o objeto real seja um Carro ou uma Moto que possua a implementação. Ter o método na base assegura que todos os herdeiros sigam a mesma assinatura, permitindo que o sistema execute ações específicas para cada tipo de objeto através de um comando único e uniforme.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem ser carro, moto, caminhão ou nada disso?

Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Por que ele não deduz isso sozinho?

Pense: Se esquecermos de colocar `abstract`, qual o risco que corremos? Alguém pode criar `new Veiculo()` e quebrar a lógica do nosso sistema?

**Resposta:**
O uso de abstract é uma trava de segurança que impede a criação de instâncias genéricas que não existem de forma isolada no mundo real, como um "veículo" que não é nem carro nem moto. Se a classe não for abstrata, um programador poderia usar o comando new Veiculo(), gerando um objeto incompleto que quebraria a lógica do sistema por não possuir regras específicas de autonomia ou identificação. A classe abstrata serve como um molde puro, obrigando a existência de subclasses concretas para que qualquer objeto real seja criado, garantindo que a hierarquia de design seja respeitada e livre de instâncias "fantasmas".

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples (apenas uma mãe), mas múltipla implementação de interfaces (vários contratos)?

Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` e de `Bateria` ao mesmo tempo (herança múltipla), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar()`?

Como as interfaces resolvem esse problema?

**Resposta:**
Diferente da herança de classes, que permite apenas uma mãe para evitar conflitos de código onde métodos iguais teriam implementações diferentes, as interfaces permitem que uma classe assine múltiplos contratos de comportamento. Como as interfaces definem apenas o "quê" deve ser feito (assinaturas) e não "como" (sem código), não há risco de conflito de lógica herdada entre elas. Isso oferece flexibilidade e segurança, permitindo que um CarroEletrico seja tratado simultaneamente como um Veiculo, algo Recarregavel e portador de GPS, sem as complicações técnicas de herdar de múltiplas classes concretas.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**

**Resposta:**
O domínio escolhido para o meu projeto pessoal foi um Sistema de Televisão.

**Quais classes você criou?**

**Resposta:**
As classes criadas foram:
- Televisao: Classe base (superclasse) que define a estrutura comum.
- SmartTV: Subclasse que representa uma televisão com recursos de internet.  
- TVPortatil: Subclasse que representa uma televisão móvel.  
- Canal: Classe associada que representa os canais disponíveis no sistema.

**Qual foi o maior desafio técnico que você enfrentou?**

**Resposta:**
O maior desafio técnico que enfrentei no início da jornada com Java foi compreender o funcionamento e a real necessidade da utilização de packages. No começo, era difícil visualizar por que não poderíamos simplesmente deixar todos os arquivos em uma única pasta e como essa estrutura de diretórios se relacionava diretamente com a organização lógica do código. Para resolver essa dificuldade, realizei uma pesquisa aprofundada em vídeos e artigos técnicos sobre a arquitetura da linguagem, focando em como o compilador Java e a JVM interpretam essas pastas para localizar as classes. Entendi que o uso de pacotes, como o padrão de domínio invertido br.com.fiapride.model, é uma convenção mundial que evita conflitos de nomes e facilita a manutenção de projetos em larga escala. Após dominar esses conceitos de infraestrutura e compilação, consegui seguir as aulas com confiança.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**

**Resposta:**
Ao longo destas 9 aulas, consolidei uma base sólida nos pilares da Programação Orientada a Objetos, compreendendo como traduzir elementos do mundo real para uma arquitetura de software escalável através da abstração. Aprendi que o encapsulamento é fundamental para a segurança dos dados, utilizando modificadores de acesso e métodos de validação para impedir estados inválidos e garantir a integridade das regras de negócio. Dominei a aplicação de herança e polimorfismo para promover o reaproveitamento de código e a flexibilidade do sistema, além de entender o papel das classes abstratas e interfaces como contratos essenciais para definir comportamentos sem gerar conflitos de implementação. Essas competências me permitiram evoluir de um código estático para um sistema dinâmico e profissional, orientado por princípios de Clean Code.

**Qual conceito foi mais difícil de entender?**

**Resposta:**
Embora os conceitos de Programação Orientada a Objetos sejam densos, não enfrentei dificuldades particulares na compreensão de nenhum tema específico, pois a progressão didática das aulas foi extremamente clara e fundamentada. Consegui assimilar com tranquilidade desde a base de abstração e encapsulamento até os tópicos mais avançados, como o polimorfismo de sobrescrita e o uso de interfaces para a gestão de múltiplos tipos. Essa clareza na exposição dos conteúdos garantiu que eu pudesse focar na correta arquitetura do sistema, assegurando que cada objeto respeitasse rigorosamente os princípios de Clean Code e os contratos estabelecidos pela hierarquia de classes.

**O que você melhoraria no seu projeto se pudesse refazer?**

**Resposta:**