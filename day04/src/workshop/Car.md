classDiagram
class Car {
<<abstract>>
-String name
-String color
-double fuelSize
-double currFuel
-int transmissionType
-Engine engine
-String carType
+drive(double distance, double speed)
+brake()
+addFuel(double size)
+toString()
}

    class Engine {
        <<abstract>>
        -int engineSerial
        -double displacement
        -int horsePower
        +start()
        +stop()
        +calculateFuelConsumption(double distance, double speed)
        +toString()
    }

    class ElectricCar {
        -double batteryCapacity
        -double batteryLevel
        +fastCharge(double minutes)
        +toString()
    }

    class FireTruck {
        -double waterTankCapacity
        -double currentWaterLevel
        -boolean isSirenOn
        +sprayWater(double amount)
        +refillWater(double amount)
        +toggleSiren()
        +toString()
    }

    class SportsCar {
        -boolean turboMode
        -int maxSpeed
        +toggleTurboMode()
        +toString()
    }

    class Tank {
        -int armorThickness
        -String weaponType
        -boolean isInCombatMode
        +toggleCombatMode()
        +fire()
        +checkArmor()
        +toString()
    }

    class Driver {
        -String name
        -int age
        -int license
        +toString()
    }

    class ElectricMotor {
        -double batteryCapacity
        -double efficiency
        +toString()
    }

    Car <|-- ElectricCar
    Car <|-- FireTruck
    Car <|-- SportsCar
    Car <|-- Tank
    Car "1" *-- "1" Engine
    Engine <|-- ElectricMotor
    Driver "1" -- "*" Car : drives