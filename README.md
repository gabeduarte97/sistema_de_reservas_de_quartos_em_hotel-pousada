# 🏨 Sistema de Reservas de Hotel

Projeto acadêmico em **Java** para a disciplina de Desenvolvimento de Software. O sistema simula um gerenciamento completo de reservas em um hotel, utilizando arquitetura **MVC**, **serialização de dados**, e aplicação de **conceitos de orientação a objetos**.

## ✅ Funcionalidades

- Cadastro, listagem e remoção de **hóspedes**
- Cadastro, listagem e remoção de **quartos** (Simples e Luxo)
- Exibição das **diárias dos quartos**
- Cadastro, listagem e remoção de **reservas**
- **Relacionamento entre entidades**: Reserva ↔️ Hóspede & Quarto
- Aplicação dos conceitos:
  - **Herança**
  - **Polimorfismo**
  - **Interfaces e classes abstratas**
- **Validações rigorosas** (ex: CPF, telefone, capacidade, datas)
- **Serialização** dos dados com arquivos `.ser` (exceto em pré-carga)
- **Pré-carga automática** de dados com hóspedes, quartos e reservas
- Geração automática de arquivo `log.txt` com o histórico do sistema
- Estrutura modular seguindo princípios de **Clean Code**
- Interface amigável em **menus de texto (terminal)**

---

## 📦 Estrutura do Projeto

```
SistemaReservasFinal/
├── controller/        # Lógica de controle (CRUDs)
├── factory/           # Criação validada de entidades (Hospede, Quarto, Reserva)
├── model/             # Domínio da aplicação (Quarto, Hospede, Reserva, etc.)
├── util/              # Utilitários (Logger, Serializador, Pré-carga, interfaces)
├── view/              # Interface via terminal (Main, MenuView)
├── dados/             # Arquivos de dados serializados (.ser)
├── log.txt            # Registro de atividades do sistema
└── README.md          # Este arquivo
```

---

## ▶️ Como Executar

1. **Abra o terminal** e acesse o diretório do projeto:
```bash
cd ~/Downloads/sistema_de_reservas
```

2. **(Opcional)** Crie a pasta de dados:
```bash
mkdir -p dados
```

3. **Compile os arquivos Java:**
```bash
find . -name "*.java" > sources.txt
javac -d bin @sources.txt
```

4. **Execute o sistema:**
```bash
java -cp bin view.Main
```

---

## 🧪 Testes Recomendados

- Verificar a **pré-carga** inicial de hóspedes, quartos e reservas
- Cadastrar novo hóspede e validar formato do telefone/CPF
- Criar e listar reservas com **quartos já cadastrados**
- Testar **diárias diferentes** de quartos Simples e Luxo
- Remover reserva com CPF + número do quarto + data
- Checar arquivos `.ser` na pasta `dados/` e `log.txt` no root

---

## 💡 Observação Importante

Em casos onde o sistema de **serialização não funcionar em outras máquinas**, o projeto conta com **pré-carga automática** de dados ao iniciar, evitando dependência de arquivos `.ser`.
