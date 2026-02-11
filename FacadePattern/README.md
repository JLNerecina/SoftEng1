# Facade Pattern - Simplified Hotel Management System

## Overview

This project demonstrates the implementation of the **Facade Pattern** in a hotel management system. The Facade Pattern provides a unified, simplified interface to a set of complex subsystems, allowing clients to interact with multiple services through a single entry point without needing to understand the underlying complexity.

In this hotel management system, the **FrontDesk** acts as a facade that abstracts the complexity of coordinating multiple hotel services (valet parking, room cleaning, and luggage handling) from the client (HotelApp).

## Problem Statement

A hotel needs to manage various services for guest check-in and check-out operations, including:
- **Valet Parking**: Parking guest vehicles and retrieving them
- **Room Cleaning**: Preparing and cleaning guest rooms
- **Luggage Handling**: Managing luggage carts for guests

### Challenge:
Without a simplified interface, the client (HotelApp) would need to:
- Know about each individual service class
- Understand the specific methods for each service
- Handle coordination between multiple services
- Manage complex interactions and dependencies

This leads to tight coupling, increased complexity, and difficult maintenance.

## Solution: Facade Pattern

The Facade Pattern provides a unified, high-level interface that makes the subsystems easier to use. It hides the complexity of coordinating multiple components and provides a single point of interaction for clients.

### Key Benefits:
✅ **Simplified Interface** - Clients interact with a single, easy-to-use interface  
✅ **Reduced Coupling** - Clients don't depend on individual service classes  
✅ **Centralized Control** - Service coordination happens in one place  
✅ **Maintainability** - Internal changes don't affect client code  
✅ **Improved Readability** - Client code is cleaner and more intuitive  
✅ **Abstraction** - Complex operations are hidden behind simple methods  

## Architecture

### System Components

```
┌────────────────────────────────────────────────────────┐
│                     HotelApp (Client)                  │
│              Interacts only with FrontDesk             │
└──────────────────────┬─────────────────────────────────┘
                       │
                       │ Uses
                       ▼
┌────────────────────────────────────────────────────────┐
│          FrontDesk (Facade)                            │
│                                                        │
│  - Provides simplified interface for hotel services    │
│  - Coordinates interactions with subsystems            │
│  - Hides implementation details                        │
└────────────┬──────────────┬──────────────┬─────────────┘
             │              │              │
    Coordinates             │              │
    and delegates           │              │
             │              │              │
             ▼              ▼              ▼
    ┌──────────────┐ ┌───────────────┐ ┌──────────┐
    │ Valet        │ │ HouseKeeping  │ │ Cart     │
    │ (Service)    │ │ (Service)     │ │ (Service)│
    └──────────────┘ └───────────────┘ └──────────┘
```

### Class Diagram

![image](https://github.com/JLNerecina/SoftEng1/blob/main/FacadePattern/UML_Simplified%20Hotel%20Management%20System.png)

## Components

### 1. HotelService Interface
Defines the common contract for all hotel services.

```java
public interface HotelService {
    void performService();
}
```

**Purpose**: Ensures all service classes follow a consistent interface, allowing the facade to treat them uniformly.

### 2. Valet Service Class
Handles vehicle parking and retrieval services.

**Responsibilities:**
- Park guest vehicles
- Retrieve vehicles for departing guests
- Manage vehicle pickup requests

**Methods:**
- `pickUpVehicle(String plateNumber)` - Retrieves a vehicle by license plate
- `parkVehicle(String plateNumber)` - Parks a vehicle in the valet lot

### 3. HouseKeeping Service Class
Manages room cleaning and preparation.

**Responsibilities:**
- Clean guest rooms
- Inspect room conditions
- Prepare rooms for new guests

**Methods:**
- `cleanRoom(String roomNumber)` - Cleans and prepares a specific room
- `inspectRoom(String roomNumber)` - Inspects room cleanliness

### 4. Cart Service Class
Handles luggage cart distribution and management.

**Responsibilities:**
- Provide luggage carts at check-in
- Collect carts at check-out
- Manage cart inventory

**Methods:**
- `requestCart(int numberOfCarts)` - Requests specified number of luggage carts
- `returnCart(int numberOfCarts)` - Returns used carts

### 5. FrontDesk Class (Facade)
The main facade that simplifies client access to hotel services.

**Responsibilities:**
- Aggregate all hotel services
- Provide simplified, high-level methods
- Coordinate complex multi-service operations
- Hide implementation details

**Methods:**
- `checkIn(String guestName, String roomNumber)` - Handles guest check-in process
- `checkOut(String guestName, String roomNumber)` - Handles guest check-out process
- `requestValet(String plateNumber)` - Requests valet service
- `requestRoomCleaning(String roomNumber)` - Requests room cleaning
- `requestLuggage(int numberOfCarts)` - Requests luggage carts

### 6. HotelApp Class (Client)
The main application that uses the FrontDesk facade.

**Usage**: Calls FrontDesk methods without knowing about individual services.

## Usage Example

```java
// Create the facade
FrontDesk frontDesk = new FrontDesk();

// Guest check-in - simplified interface handles multiple services
frontDesk.checkIn("John Doe", "Room 101");
// Behind the scenes:
// - HouseKeeping prepares the room
// - Cart service provides luggage carts

// Request additional services
frontDesk.requestValet("ABC123");      // Park vehicle
frontDesk.requestRoomCleaning("101");  // Clean room
frontDesk.requestLuggage(2);           // Get 2 luggage carts

// Guest check-out
frontDesk.checkOut("John Doe", "Room 101");
// Behind the scenes:
// - Valet retrieves vehicle
// - Cart service collects luggage carts
// - HouseKeeping inspects room
```

## Design Patterns & Principles

### Pattern: Facade
- **Intent**: Provide a unified interface to a set of subsystems
- **Implementation**: FrontDesk class coordinates Valet, HouseKeeping, and Cart services
- **Benefit**: Clients use simple methods instead of managing multiple service classes

### SOLID Principles Applied

#### Single Responsibility Principle (SRP)
- Each service class has one responsibility
- FrontDesk focuses on coordination and delegation

#### Open/Closed Principle (OCP)
- Easy to add new services without modifying existing code
- Can extend HotelService interface with new implementations

#### Dependency Inversion Principle (DIP)
- Depend on abstractions (HotelService interface) not concrete classes
- FrontDesk depends on the interface, not specific implementations

#### Interface Segregation Principle (ISP)
- HotelService interface is focused and minimal
- Clients use only what they need

## File Structure

```
HotelManagementSystem/
├── HotelService.java          # Interface defining service contract
├── Valet.java                 # Valet parking service
├── HouseKeeping.java          # Room cleaning service
├── Cart.java                  # Luggage cart service
├── FrontDesk.java             # Facade coordinating all services
├── HotelApp.java              # Client application
└── README.md                  # This file
```

## Workflow Diagrams

### Check-In Process
```
Guest Arrives
     │
     ▼
HotelApp calls frontDesk.checkIn()
     │
     ▼
FrontDesk Facade (Coordinates):
     ├─► HouseKeeping.cleanRoom()
     ├─► Cart.requestCart()
     └─► Display confirmation
     │
     ▼
Guest Settled In
```

### Check-Out Process
```
Guest Departs
     │
     ▼
HotelApp calls frontDesk.checkOut()
     │
     ▼
FrontDesk Facade (Coordinates):
     ├─► Valet.pickUpVehicle()
     ├─► Cart.returnCart()
     ├─► HouseKeeping.inspectRoom()
     └─► Display bill
     │
     ▼
Guest Leaves
```

## Key Features

- 🎯 **Simplified Interface** - Single entry point for all services
- 🔄 **Service Coordination** - Complex operations managed seamlessly
- 🔒 **Encapsulation** - Service details hidden from client
- 📊 **Clean Architecture** - Clear separation of concerns
- ✨ **Easy to Extend** - Add new services without breaking existing code
- 🧪 **Testable** - Can mock services for testing
- 📖 **Well-Documented** - Clear comments throughout code

## Advantages Over Direct Service Access

| Aspect | Without Facade | With Facade |
|--------|---|---|
| **Complexity** | Client manages multiple services | Single interface |
| **Coupling** | High - depends on all services | Low - depends only on facade |
| **Maintenance** | Changes in services affect clients | Changes isolated to facade |
| **Learning Curve** | Must understand all services | Only learn facade interface |
| **Code Clarity** | Complex and scattered | Simple and readable |
| **Extensibility** | Difficult to add services | Easy to add new services |
| **Testing** | Must mock multiple objects | Mock only facade |

## Real-World Applications

The Facade Pattern is commonly used in:
- 🏨 Hotel management systems (this project)
- 🏦 Banking systems (single interface for multiple operations)
- 🎬 Home theater systems (unified control)
- 📚 Library management systems (simplified catalog access)
- 🛒 E-commerce platforms (checkout process)
- 🚗 Car rental systems (booking and services)
- 🏥 Hospital management systems (patient services)

## Implementation Tips

1. **Identify Subsystems**: Determine which services/components need coordination
2. **Create Interface**: Define common interface if subsystems don't share one
3. **Build Facade**: Aggregate subsystems and provide simplified methods
4. **Add Logic**: Implement coordination and delegation in facade methods
5. **Use Facade**: Have clients interact only with facade, not subsystems

## Best Practices

✅ **Facade should be simple** - If it becomes too complex, consider breaking it down  
✅ **Avoid god object** - Don't add unrelated responsibilities to facade  
✅ **Keep subsystems independent** - Services should work independently if needed  
✅ **Document facade methods** - Make high-level operations clear  
✅ **Use composition** - Aggregate services rather than inherit  
✅ **Test subsystems separately** - Each service should be independently testable  

## Potential Extensions

```java
// Add support for special requests
public void requestSpecialService(String serviceType, String details)

// Handle concurrent check-ins
public void batchCheckIn(List<Guest> guests)

// Track service requests
public void trackServiceRequest(String requestId)

// Cancel service requests
public void cancelService(String requestId)

// Get service status
public String getServiceStatus(String requestId)
```

## Comparison with Other Patterns

| Pattern | Purpose | Use Case |
|---------|---------|----------|
| **Facade** | Simplify complex subsystems | Hotel services, home theater |
| **Adapter** | Make incompatible interfaces compatible | Converting formats |
| **Bridge** | Decouple abstraction from implementation | Device drivers |
| **Proxy** | Control access to another object | Lazy loading, caching |
| **Decorator** | Add behavior dynamically | Coffee shop ordering |

## Conclusion

The Facade Pattern provides an elegant solution for managing complex interactions between multiple subsystems. This hotel management system demonstrates how a simple facade can dramatically improve code readability, maintainability, and usability while reducing coupling between components.

By using the FrontDesk facade, clients can efficiently request hotel services without needing to understand the intricacies of valet parking, housekeeping, or luggage handling—making the system both developer-friendly and user-friendly.

## Author
**JLNerecina** - Facade Pattern Lab Activity

## Date Created
November 2025

## References
- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)
- Refactoring.Guru - Facade Pattern
- Wikipedia - Facade Pattern
