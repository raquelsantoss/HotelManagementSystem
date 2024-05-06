# AT3/N1 - Controle de Quartos em Hotel

[![GitHub license](https://img.shields.io/github/license/yourusername/controle-quartos-hotel)](https://github.com/yourusername/controle-quartos-hotel/blob/main/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/yourusername/controle-quartos-hotel)](https://github.com/yourusername/controle-quartos-hotel/issues)
[![GitHub stars](https://img.shields.io/github/stars/yourusername/controle-quartos-hotel)](https://github.com/yourusername/controle-quartos-hotel/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/yourusername/controle-quartos-hotel)](https://github.com/yourusername/controle-quartos-hotel/network)

Este projeto simula um sistema de reserva e controle de quartos em um hotel, utilizando threads para representar diferentes entidades envolvidas, como hóspedes, camareiras, recepcionistas e camareira. O sistema foi desenvolvido como uma atividade prática coletiva para o Bimestre N1.

## Estrutura de Pastas

.
├── src
│   ├── hotel
│   │   └── Main.java
│   ├── entity
│   │   ├── Quarto.java
│   │   ├── Hospede.java
│   │   ├── Camareira.java
│   │   └── Recepcionista.java
│   └── test
│       └── Test.java
└── README.md

## Entidades Representadas

1. **Quarto**
   - São disponibilizados no mínimo 10 quartos.
  
2. **Hóspede**
   - Cada hóspede é representado por uma thread.
   - Existem no mínimo 50 hóspedes.

3. **Camareira**
   - Cada camareira é representada por uma thread.
   - São disponibilizadas no mínimo 10 camareiras.

4. **Recepcionista**
   - Cada recepcionista é representado por uma thread.
   - Existem no mínimo 5 recepcionistas.

## Regras do Sistema

- Os recepcionistas devem alocar hóspedes apenas em quartos vagos.
- O hotel deve contar com várias camareiras para limpeza dos quartos.
- Cada quarto tem capacidade para até 4 hóspedes e uma única chave.
- Grupos ou famílias com mais de 4 membros devem ser divididos em vários quartos.
- Os hóspedes devem deixar a chave na recepção ao saírem do hotel para passear.
- Uma camareira só pode entrar em um quarto se estiver vago ou sem hóspedes.
- A limpeza dos quartos é feita após a saída dos hóspedes.
- Um quarto vago em limpeza não pode ser alocado para um novo hóspede.
- Se não houver quartos vagos, os novos hóspedes devem esperar em fila.
- Se a espera for longa, os hóspedes podem sair e retornar para tentar alugar um quarto novamente.
- Se não conseguirem alugar um quarto após duas tentativas, os hóspedes deixam uma reclamação e vão embora.

## Observações

- Não é possível para apenas parte dos hóspedes de um quarto sair para passear.
- O sistema deve simular diversas situações, como chegada de diferentes números de hóspedes, grupos grandes, todos os quartos ocupados, etc.
- É necessário garantir sincronia e coordenação entre as diferentes entidades do sistema.
  
---
Este projeto foi desenvolvido como parte de uma atividade acadêmica e visa demonstrar a aplicação de conceitos de concorrência e sincronização em Java para simulação de um sistema de reserva e controle de quartos em um hotel.
