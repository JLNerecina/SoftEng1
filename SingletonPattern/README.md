# Centralized Queuing System for Pag-ibig Office

## Overview

A robust queuing management system designed for the Pag-ibig office that provides centralized queue management across multiple help desk stations with real-time monitoring capabilities.

## Features

### 🎫 Centralized Queue Management
- **Single Queue Number Source**: All three help desk stations draw from a unified, centralized queue number system
- **Consistent Queue State**: Ensures no duplicate or conflicting queue assignments across stations

### 📊 Real-Time Monitoring
- **Live Queue Display**: Online monitoring system displays the current queued number in real-time
- **Remote Access**: Individuals can monitor queue status remotely without visiting the office
- **Instant Updates**: Queue information is synchronized across all stations and monitoring endpoints

### 🔧 Queue Reset & Control
- **Flexible Reset Options**: Each help desk station has the ability to reset the queue number to a specified value
- **Exceptional Circumstance Handling**: Accommodates queue adjustments for:
  - System reorganization
  - Technical issue resolution
  - Special operational requirements
- **Operator Control**: Provides office staff with necessary tools to manage queue flow

## System Architecture

### Design Pattern
This system implements the **Singleton Pattern** to ensure a single, shared instance of the queue number across all help desk stations.

### Class Diagram
```
[Insert UML Diagram]
```
![Singleton Pattern UML Diagram](https://github.com/JLNerecina/SoftEng1/blob/main/SingletonPattern/SingletonPatternUML.png)

## How It Works

1. **Queue Number Generation**: A visitor obtains a queue number from the centralized system upon arrival
2. **Help Desk Processing**: Help desk stations call customers based on the centralized queue order
3. **Real-Time Visibility**: Monitoring systems display the current number being served or next in queue
4. **Queue Adjustment**: If needed, operators can reset the queue counter to manage exceptional situations

## Benefits

✅ **Elimination of Queue Conflicts**: Single source of truth prevents duplicate queue numbers  
✅ **Improved Customer Experience**: Visitors can monitor their position in queue remotely  
✅ **Operational Flexibility**: Ability to adjust queue numbers when necessary  
✅ **Scalability**: Easy to extend to additional help desk stations  
✅ **Reduced Wait Time Confusion**: Clear, centralized queue information

## Technical Implementation

- **Pattern**: Singleton Pattern (ensures single queue instance)
- **Scope**: 3+ Help Desk Stations
- **Access**: Local office + Online monitoring
- **Management**: Queue reset capability per station

**Last Updated**: February 2026
