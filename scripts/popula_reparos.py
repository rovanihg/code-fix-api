import json
import requests

# URL da sua API rodando no Spring Boot
URL = "http://localhost:8080/api/reparos"

# Lista de reparos reais da bancada para teste
reparos_exemplo = [
    {
        "aparelho": "iPhone 11",
        "defeito": "Reconstrução de malha PP_VCC_MAIN sob microscópio",
        "valor": 350.00,
        "status": "CONCLUIDO",
    },
    {
        "aparelho": "Samsung Galaxy S20 FE",
        "defeito": "Substituição de CI de Carga (PMIC) e jumper em conector FPC",
        "valor": 280.00,
        "status": "EM_ANDAMENTO",
    },
    {
        "aparelho": "Xiaomi Redmi Note 10",
        "defeito": "Curto-circuito em capacitor da linha principal",
        "valor": 180.00,
        "status": "CONCLUIDO",
    },
]

headers = {"Content-Type": "application/json"}

print("🚀 Iniciando envio de dados para a API Java...\n")

for reparo in reparos_exemplo:
    try:
        response = requests.post(URL, data=json.dumps(reparo), headers=headers)
        if response.status_code == 201:
            dados = response.json()
            print(
                f"✅ Cadastrado: ID {dados['id']} - {dados['aparelho']} ({dados['defeito']})"
            )
        else:
            print(
                f"❌ Erro ao cadastrar {reparo['aparelho']}: Status {response.status_code}"
            )
    except Exception as e:
        print(f"⚠️ Erro de conexão com a API: {e}")

print("\n✨ Processo finalizado!")