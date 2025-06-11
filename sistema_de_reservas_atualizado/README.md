
# Sistema de Reservas de Hotel

Este é um projeto acadêmico em Java para a disciplina de Desenvolvimento de Software. Ele simula um sistema de reservas de hotel com interface via terminal, seguindo o padrão MVC e contemplando todos os requisitos solicitados no projeto final.

## ✅ Funcionalidades

- Cadastro, listagem e remoção de **hóspedes**
- Cadastro, listagem e remoção de **quartos**
- Cadastro, listagem e remoção de **reservas**
- Relacionamento entre entidades (Reserva <-> Hóspede & Quarto)
- Uso de **herança**, **interface**, **classe abstrata**, **polimorfismo**
- **Serialização** dos dados em arquivos `.ser`
- Geração de **log.txt** para atividades do sistema
- Estrutura limpa e modular, com princípios de **Clean Code**
- Interface baseada em **menus de texto** no terminal

## 📁 Estrutura do Projeto

```
SistemaReservasFinal/
├── controller/        # Lógica de controle (CRUDs)
├── model/             # Classes de domínio (Quarto, Hóspede, Reserva...)
├── util/              # Utilitários: Logger, Serializador, Interface Autenticável
├── view/              # Interface de texto (MenuView, Main.java)
├── dados/             # Dados serializados (.ser)
└── log.txt            # Log de atividades
```

## ▶️ Como Executar

1. **Abra o terminal** e vá até a pasta do projeto:

```bash
cd ~/Downloads/SistemaReservasFinal
```

2. **Crie a pasta de dados (se ainda não existir):**
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

## 🧪 Testes Recomendados

- Cadastrar um hóspede e listá-lo
- Cadastrar um quarto e listá-lo
- Criar uma reserva com os dados anteriores
- Listar reservas e removê-las usando CPF + número do quarto + data
- Verificar os arquivos `.ser` e `log.txt` na pasta `dados/`

