# Comparison: Composition (GOOD) vs Inheritance (BAD)

## What does the GOOD approach (composition) allow that the BAD approach (inheritance) does not?

### 1️⃣ Combine behaviors without creating new classes

**❌ BAD (inheritance)**

Each combination requires a new subclass:
- AutopilotElectricCar
- AutopilotCombustionCar
- ManualElectricCar
- ManualCombustionCar
- ...

➡️ The number of classes grows multiplicatively.

**✅ GOOD (composition)**

Behaviors are independent objects:

`new Transport(new ElectricEngine(), new RobotDriver());`

➡️ No new class is created for each combination.

**📌 Exclusive capability of composition:** Dynamically combine behaviors without changing the hierarchy.

---

### 2️⃣ Swap behavior at runtime

**❌ BAD**

Behavior is "frozen" in the class:

`AutopilotElectricCar car = new AutopilotElectricCar();`

// impossible to become a ManualElectricCar
➡️ Need to create another object of a different class.

**✅ GOOD**

Behavior is delegatable:

`transport.setDriver(new HumanDriver());`

`transport.setEngine(new CombustionEngine());`

➡️ The same object changes behavior.

**📌 This is simply not possible with classic inheritance.**

---

### 3️⃣ Evolve one dimension without touching others

**❌ BAD**

Adding a new type of driver (Human, Robot, AI) requires:
- AI_ElectricCar
- AI_CombustionCar
- AI_ElectricTruck
- ...

**✅ GOOD**

Adding a new driver:

`class AIDriver implements Driver { ... }`

➡️ Zero impact on Engine, Transport, etc.

**📌 This is Open/Closed Principle in practice.**

---

### 4️⃣ Reduce coupling (changes don't break everything)

**❌ BAD**

Subclasses depend on:
- Implementation of the superclass
- Protected details
- Call order (super.method())
  ➡️ Changes in the superclass break subclasses.

**✅ GOOD**

Transport depends only on interfaces:
- private Engine engine;
- private Driver driver;
➡️ Internal changes do not leak.

**📌 Composition preserves encapsulation.**

---

### 5️⃣ Avoid deep and fragile hierarchies

**❌ BAD**
Typical hierarchy:
```bash
Transport
└── Car
    └── ElectricCar
        └── AutopilotElectricCar
 ```
➡️ Fragile, rigid, hard to understand.

**✅ GOOD**
Shallow and independent hierarchies:
- Transport
- Engine hierarchy
- Driver hierarchy
  ➡️ Simple, predictable, sustainable.

---

### 6️⃣ Test behaviors in isolation

**❌ BAD**
To test navigation:
- Need to instantiate the entire subclass
- With engine, vehicle, etc.

**✅ GOOD**

Simple unit test:

`Driver driver = new RobotDriver();`

`driver.navigate("Point A");`

**📌 Testability is drastically better.**

---

### 7️⃣ Reuse behavior outside the original context

**❌ BAD**
Autopilot is "stuck" to the vehicle hierarchy.

**✅ GOOD**
Driver can be reused in:
- Drones
- Boats
- Simulators
- Tests

**📌 Composition maximizes real reuse.**

---

### 8️⃣ Model the domain correctly

**❌ BAD**

Inheritance forces artificial "is-a" relationships:

"AutopilotElectricCar is an ElectricCar"

"ElectricCar is a Car"

But:
- Autopilot is not a car
- Engine is not a type of vehicle

**✅ GOOD**

Models real relationships:

- Transport **has an** Engine
- Transport **has a** Driver

**📌 The model reflects the real world.**

---

## Definitive Summary

**❌ BAD (inheritance)**
- Class explosion
- Fixed behavior
- High coupling
- Hard to evolve
- Fragile
- Low reusability

**✅ GOOD (composition)**
- Free combination of behaviors
- Runtime swapping
- Low coupling
- Independent evolution
- Better testability
- Model more faithful to the domain

---

## When is inheritance appropriate?

Inheritance is appropriate when:

1. **The "is-a" relationship is genuine and stable** - When a class is truly a specialization of another (ex: `Dog extends Animal`)
2. **There is no need for multiple dimensions of variation** - When behavior does not need to be combined in various ways
3. **The hierarchy is simple and predictable** - When there is no risk of class explosion
4. **Behavior is fixed for the object's entire lifetime** - When there is no need to swap behavior at runtime
5. **Implementation reuse is the primary goal** - When you actually want to inherit implementation, not just behavior
6. **Framework or language requires it** - When working with frameworks that were designed with inheritance in mind

**General rule:** Prefer composition by default. Use inheritance only when there is a clear, stable, and permanent "is-a" relationship in the problem domain.


---

PT

---

# Comparação: Composição (GOOD) vs Herança (BAD)

## O que a abordagem GOOD (composição) permite que a BAD (herança) não permite?

### 1️⃣ Combinar comportamentos sem criar novas classes

**❌ BAD (herança)**
Cada combinação exige uma nova subclasse:
- AutopilotElectricCar
- AutopilotCombustionCar
- ManualElectricCar
- ManualCombustionCar
- ...

➡️ O número de classes cresce multiplicativamente.

**✅ GOOD (composição)**
- Comportamentos são objetos independentes:

new Transport(new ElectricEngine(), new RobotDriver()
  ); 

  ➡️ Nenhuma nova classe é criada para cada combinação.

**📌 Capacidade exclusiva da composição:** Combinar comportamentos dinamicamente sem alterar a hierarquia.

---

### 2️⃣ Trocar comportamento em tempo de execução

**❌ BAD**

O comportamento está "congelado" na classe:

AutopilotElectricCar car = new AutopilotElectricCar();

// impossível virar ManualElectricCar

➡️ Precisa criar outro objeto de outra classe.

**✅ GOOD**

O comportamento é delegável:

transport.setDriver(new HumanDriver());

transport.setEngine(new CombustionEngine());

➡️ O mesmo objeto muda de comportamento.

**📌 Isso simplesmente não é possível com herança clássica.**

---

### 3️⃣ Evoluir uma dimensão sem tocar nas outras

**❌ BAD**

Adicionar um novo tipo de driver (Human, Robot, AI) exige:

    - AI_ElectricCar
    - AI_CombustionCar
    - AI_ElectricTruck
    - ...

**✅ GOOD**

Adicionar um novo driver:
class AIDriver implements Driver { ... }

➡️ Zero impacto em Engine, Transport, etc.

**📌 Isso é Open/Closed Principle na prática.**

---

### 4️⃣ Reduzir acoplamento (mudanças não quebram tudo)

**❌ BAD**
Subclasses dependem de:
- Implementação da superclasse
- Detalhes protegidos (protected)
- Ordem de chamada (super.method())

  ➡️ Mudanças na superclasse quebram subclasses.

**✅ GOOD**

Transport depende apenas de interfaces:

    - private Engine engine;
    - private Driver driver;

➡️ Mudanças internas não vazam.

**📌 Composição preserva encapsulamento.**

---

### 5️⃣ Evitar hierarquias profundas e frágeis

**❌ BAD**

    Hierarquia típica:
    Transport
    └── Car
      └── ElectricCar
        └── AutopilotElectricCar

➡️ Frágil, rígida, difícil de entender.

**✅ GOOD**

Hierarquias rasas e independentes:
- Transport
- Engine hierarchy
- Driver hierarchy

  ➡️ Simples, previsível, sustentável.

---

### 6️⃣ Testar comportamentos isoladamente

**❌ BAD**

Para testar navegação:
- Precisa instanciar a subclasse inteira
- Com motor, veículo, etc.

**✅ GOOD**

Teste unitário simples:

    Driver driver = new RobotDriver();
    driver.navigate("Point A");

**📌 Testabilidade é drasticamente melhor.**

---

### 7️⃣ Reutilizar comportamento fora do contexto original

**❌ BAD**

Autopilot está "preso" à hierarquia de veículos.

**✅ GOOD**

Driver pode ser reutilizado em:
- Drones
- Barcos
- Simuladores
- Testes

**📌 Composição maximiza reutilização real.**

---

### 8️⃣ Modelar corretamente o domínio

**❌ BAD**

Herança força relações "é um" artificiais:
"AutopilotElectricCar é um ElectricCar"
"ElectricCar é um Car"
Mas:
- Autopilot não é um carro
- Engine não é um tipo de veículo

**✅ GOOD**

Modela relações reais:
- Transport **tem um** Engine
- Transport **tem um** Driver

**📌 O modelo reflete o mundo real.**

---

## Resumo definitivo

**❌ BAD (herança)**
- Explosão de classes
- Comportamento fixo
- Alto acoplamento
- Difícil evolução
- Frágil
- Pouco reutilizável

**✅ GOOD (composição)**
- Combinação livre de comportamentos
- Troca em runtime
- Baixo acoplamento
- Evolução independente
- Melhor testabilidade
- Modelo mais fiel ao domínio

---

## Quando a herança é apropriada?

A herança é apropriada quando:

1. **Relação "é um" é genuína e estável** - Quando uma classe realmente é uma especialização de outra (ex: `Cachorro extends Animal`)
2. **Não há necessidade de múltiplas dimensões de variação** - Quando o comportamento não precisa ser combinado de várias formas
3. **Hierarquia é simples e previsível** - Quando não há risco de explosão de classes
4. **Comportamento é fixo para toda a vida do objeto** - Quando não há necessidade de trocar comportamento em runtime
5. **Reutilização de implementação é o objetivo principal** - Quando você realmente quer herdar implementação, não apenas comportamento
6. **Framework ou linguagem exige** - Quando trabalha com frameworks que foram projetados com herança em mente

**Regra geral:** Prefira composição por padrão. Use herança apenas quando houver uma relação clara, estável e permanente de "é um" no domínio do problema.