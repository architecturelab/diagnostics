# diagnostics

## API REST

### CLASE
- Crear
  - URL: POST- http://34.122.37.103/diagnostics/type
  - Ejemplo request:
    ```json
    {
    "nombre": "clase 1",
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Actualizar
  - URL: PUT- http://34.122.37.103/diagnostics/type
  - Ejemplo request:
    ```json
    {
    "claseId": <<claseId>>,
    "nombre": "clase 1",
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Listar todos
  - URL: GET- http://34.122.37.103/diagnostics/types
- Consultar por Id:
  - URL: GET- http://34.122.37.103/diagnostics/type/{id}
### MARCA
- Crear
  - URL: POST- http://34.122.37.103/diagnostics/brand
    - Ejemplo request:
      ```json
      { 
      "nombre": "marca 1",
      "vidaUtil": "d5",
      "vigente": "si"
      }
- Actualizar
  - URL: PUT- http://34.122.37.103/diagnostics/brand
  - Ejemplo request:
    ```json
    {
    "marcaId": <<marcaId>>,
    "nombre": "marca 1",
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Listar todos
    - URL: GET- http://34.122.37.103/diagnostics/brands
- Consultar por Id:
    - URL: GET- http://34.122.37.103/diagnostics/brand/{id}
### MODELO
- Crear
- URL: POST- http://34.122.37.103/diagnostics/model
  - Ejemplo request:
    ```json
    { 
    "nombre": "model 1",
    "marcaId": <<marcaId>>,
    "vidaUtil": "d5",
    "vigente": "si"
    }
- Actualizar
  - URL: PUT- http://34.122.37.103/diagnostics/model
    - Ejemplo request:
      ```json
      {
      "modeloId": <<modeloId>>,
      "nombre": "model 1",
      "marcaId": <<marcaId>>,
      "vidaUtil": "d5",
      "vigente": "si"
      }
- Listar todos
  - URL: GET- http://34.122.37.103/diagnostics/models
- Consultar por Id:
  - URL: GET- http://34.122.37.103/diagnostics/model/{id}
### DEPENDENCIA
- Crear
  - URL: POST- http://34.122.37.103/diagnostics/dependency
    - Ejemplo request:
      ```json
      { 
      "nombre": "dependencia 1",
      "vigente": "si"
      }
- Actualizar
  - URL: PUT- http://34.122.37.103/diagnostics/dependency
    - Ejemplo request:
      ```json
      {
      "dependenciaId": <<dependenciaId>>,
      "nombre": "dependencia 1",
      "vigente": "si"
      }
- Listar todos
    - URL: GET- http://34.122.37.103/diagnostics/dependencies
- Consultar por Id:
    - URL: GET- http://34.122.37.103/diagnostics/dependency/{id}
### ITEM
- Crear
  - URL: POST- http://34.122.37.103/diagnostics/item
    - Ejemplo request:
      ```json
      { 
      "claseId": <<claseId>>,
      "marcaId": <<marcaId>>,
      "modeloId": <<modeloId>>,
      "serial": "132165498301",
      "fechaIngreso": "2020-04-02",
      "fechaFinalGarantia": "2025-04-02",
      "valor": 2000000.00,
      "fechaBaja": "2025-03-30",
      "dependenciaId": <<dependenciaId>>
      }
- Actualizar
  - URL: PUT- http://34.122.37.103/diagnostics/item
    - Ejemplo request:
      ```json
      {
      "itemId": <<itemId>>
      "claseId": 5,
      "marcaId": 7,
      "modeloId": 9,
      "serial": "132165498301",
      "fechaIngreso": "2020-04-02",
      "fechaFinalGarantia": "2025-04-02",
      "valor": 2000000.00,
      "fechaBaja": "2025-03-30",
      "dependenciaId": 3
      }
- Listar todos
  - URL: GET- http://34.122.37.103/diagnostics/items
- Consultar por Id:
  - URL: GET- http://34.122.37.103/diagnostics/item/{id}