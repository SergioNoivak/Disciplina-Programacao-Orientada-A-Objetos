# Programação Orientada a Objetos (ESW448) — UniRV (2026-01)

Este repositório contém o material didático, planos de aula, apresentações em LaTeX/Beamer, diagramas UML (PlantUML), listas de exercícios e códigos de exemplo da disciplina de **Programação Orientada a Objetos (ESW448)** do curso de Engenharia de Software da **Universidade de Rio Verde (UniRV)**, ministrada no semestre 2026-01.

---

## 📌 Sumário

- [Visão Geral](#-visão-geral)
- [Estrutura do Repositório](#-estrutura-do-repositório)
- [Conteúdo Programático](#-conteúdo-programático)
- [Modelagem e Ferramentas](#-modelagem-e-ferramentas)
- [Segurança e Privacidade](#-segurança-e-privacidade)
- [Como Utilizar](#-como-utilizar)

---

## 🎓 Visão Geral

A disciplina tem como objetivo apresentar os fundamentos teóricos e práticos do paradigma da **Programação Orientada a Objetos (POO)** utilizando a linguagem **Java**, capacitando os alunos a estruturar sistemas modulares, reusáveis e de fácil manutenção.

---

## 📂 Estrutura do Repositório

```text
.
├── aulas/                                 # Apresentações, listas de exercícios e exemplos práticos
│   ├── 1.Introdução/                      # Conceitos básicos e fundamentos do paradigma
│   ├── 2.Classes, objetos, atributos e métodos/ # Definição de tipos, métodos e diagramas UML
│   ├── 3.Encapsulamento/                  # Modificadores de acesso, getters/setters e ocultação
│   ├── 4. Herança e Composição/           # Relacionamentos entre classes, reuso e acoplamento
│   ├── 5. Atributos, métodos e classes static/ # Membros de classe vs. membros de instância
│   ├── 6. Classes Abstratas/              # Abstração de dados e contratos de implementação
│   ├── 6. Exercicio N2/                   # Exercícios e listas preparatórias para N2
│   ├── 7. Tratamento de Excecoes/         # Blocos try-catch-finally, checked e unchecked exceptions
│   ├── 8. Collections/                    # Framework de coleções em Java (List, Set, Map, etc.)
│   └── teste/                             # Experimentos e códigos de teste
├── provas/                                # Arquivos de exames e avaliações
│   ├── n1/                                # Provas e listas da primeira etapa (N1)
│   └── n2/                                # Provas e listas da segunda etapa (N2)
├── notas/                                 # Registro privado de notas (protegido pelo .gitignore)
├── Programa de Disciplina - ESW448.pdf    # Ementa e plano de ensino oficial
├── Modelo Institucional - CRONOGRAMA.doc  # Cronograma de aulas
├── Modelo Institucional - PROGRAMA.doc    # Programa pedagógico
└── README.md                              # Documentação principal do repositório
```

---

## 📚 Conteúdo Programático

| Módulo | Tópico Principal | Descrição e Conceitos Chave |
| :--- | :--- | :--- |
| **01** | Introdução à POO | Comparativo entre paradigma imperativo/procedural e POO, conceitos fundamentais e ambiente de desenvolvimento. |
| **02** | Classes, Objetos, Atributos e Métodos | Definição de modelos, instanciação, estados, comportamentos e representação inicial em UML. |
| **03** | Encapsulamento | Modificadores de visibilidade (`public`, `private`, `protected`), controle de acesso e proteção de atributos. |
| **04** | Herança e Composição | Extensão de classes, sobrescrita de métodos (`@Override`), reutilização de código e a regra "é-um" vs. "tem-um". |
| **05** | Membros Estáticos (`static`) | Métodos e atributos de classe, constantes, métodos utilitários e ciclo de vida estático. |
| **06** | Classes Abstratas | Definição de contratos, classes parciais, métodos abstratos e polimorfismo. |
| **07** | Tratamento de Exceções | Fluxo de erros em Java, exceções checadas (*checked*) e não-checadas (*unchecked*), lançamento e captura. |
| **08** | Java Collections Framework | Manipulação de dados com `ArrayList`, `LinkedList`, `HashSet`, `HashMap` e iteradores. |

---

## 🛠️ Modelagem e Ferramentas

- **Linguagem Principal:** Java (JDK 17+)
- **Diagramação UML:** [PlantUML](https://plantuml.com/) (`.puml`)
- **Apresentações Didáticas:** LaTeX / Beamer (`.tex`)
- **IDE Recomendada:** IntelliJ IDEA, Eclipse ou VS Code (com Java Extension Pack)

---

## 🔒 Segurança e Privacidade

Este repositório possui uma regra estrita configurada via `.gitignore` para proteger dados acadêmicos sensíveis:

> ⚠️ **Atenção:** A pasta `notas/` contém planilhas de avaliações dos estudantes e **NÃO deve ser sincronizada ou tornada pública** em repositórios remotos.

---

## 🚀 Como Utilizar

### Compilar materiais em LaTeX (Slides/Provas)
Para compilar as apresentações Beamer ou listas em LaTeX localmente:
```bash
pdflatex main.tex
# ou utilizando latexmk
latexmk -pdf main.tex
```

### Executar códigos de exemplo Java
Para compilar e executar arquivos Java através do terminal:
```bash
javac caminho/para/Arquivo.java
java caminho/para/Arquivo
```
