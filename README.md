# diagnostics

## API REST

- Crear
  - URL: POST- http://35.188.161.45/diagnostics/diagnostic
  - Ejemplo request:
    ```json
    {
    "nombre": "clase 1",
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Actualizar
  - URL: PUT- http://35.188.161.45/diagnostics/diagnostic
  - Ejemplo request:
    ```json
    {
    "claseId": <<claseId>>,
    "nombre": "clase 1",
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Listar todos
  - URL: GET- http://35.188.161.45/diagnostics/diagnostics
- Consultar por Id:
  - URL: GET- http://35.188.161.45/diagnostics/diagnostic/{id}