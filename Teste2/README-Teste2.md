
# Teste 2
# 🏢 Modelagem de Processo com BPMN

Este repositório contém o diagrama BPMN referente ao **processo de Solicitação de Férias**, modelado conforme a notação **BPMN 2.0**.

### Arquivos
 - BPMN - [solicitacao-ferias.bpmn](solicitacao-ferias.bpmn)
 - PNG - [solicitacao-ferias.png](solicitacao-ferias.png)

## 📄 Descrição do Processo

O diagrama representa o processo de **Solicitação de Férias** dentro de uma empresa, considerando três participantes principais, organizados em Lanes dentro do Pool **“Empresa”**:

- **Colaborador**
- **Gestor**
- **RH (Recursos Humanos)**

### 🔗 Fluxo do Processo:

1. O processo inicia quando o **Colaborador** expressa o desejo de solicitar férias, preenchendo uma solicitação.
2. A solicitação é então encaminhada ao **Gestor**, que realiza a análise.
3. No **Gateway de decisão “Aprovado?”**, o gestor escolhe entre:
   - ✔️ **Aprovar:** O processo segue para o **RH**, que realiza o agendamento das férias no sistema e confirma as datas com o colaborador. O processo então se encerra com as férias agendadas e confirmadas.
   - ❌ **Rejeitar:** O processo é encerrado com a solicitação de férias rejeitada.

### ✅ Observações Importantes:

- O uso de **Lanes** permite visualizar claramente quais atividades são de responsabilidade de cada participante no processo.
- As conexões são feitas por **Sequence Flow**, representando o fluxo interno de atividades dentro da organização (**Pool Empresa**).
- Não há necessidade de **Message Flow**, pois todas as interações ocorrem internamente no mesmo Pool.
