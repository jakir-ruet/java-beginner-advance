### Welcome to Oracle Database 21c

![Architecture of Oracle](/img/oracle-architecture-simplified.png)

### Core Definition

An Oracle Database system consists of **two** main components:

- Instance (Memory + Background Processes)
- Database (Physical Files on Disk)

> **Key Distinction:**
> - An instance can mount and open only one database.
> - A database can be mounted and opened by one or more instances (Real Application Clusters/RAC).

### The instance

The instance is the software layer that manages the database. It exists in volatile memory (RAM) and comprises:

#### **System Global Area (SGA)**

A group of shared memory structures that contain data and control information for the instance. All server and background processes share the SGA.

| Component                 | Standard Purpose                                                       | Mandatory? |
| ------------------------- | ---------------------------------------------------------------------- | ---------- |
| **Shared Pool**           | Caches SQL/PLSQL and data dictionary (execution plans + metadata).     | Yes        |
| **Database Buffer Cache** | Stores data blocks read from datafiles for fast access.                | Yes        |
| **Redo Log Buffer**       | Stores change records (redo) for recovery before writing to redo logs. | Yes        |
| **Large Pool**            | Used for RMAN, parallel queries, shared server memory.                 | No         |
| **Java Pool**             | Memory for Oracle JVM (Java stored procedures).                        | No         |
| **Streams Pool**          | Used for replication (Streams / GoldenGate support).                   | No         |
| **Fixed SGA**             | Internal Oracle control structures and runtime metadata.               | Yes        |

#### **Background Processes**

Processes that run continuously to manage I/O, monitor other processes, and perform maintenance.

Mandatory Background Processes

| Process  | Full Name       | Standard Function                                        |
| -------- | --------------- | -------------------------------------------------------- |
| **DBWn** | Database Writer | Writes dirty buffers from buffer cache → datafiles       |
| **LGWR** | Log Writer      | Writes redo buffer → online redo logs (commit / timeout) |
| **CKPT** | Checkpoint      | Updates datafiles & control files with checkpoint info   |
| **SMON** | System Monitor  | Instance recovery + cleanup of temporary segments        |
| **PMON** | Process Monitor | Cleans failed sessions, releases locks, frees resources  |
| **RECO** | Recoverer       | Resolves distributed transaction failures (2PC)          |
| **MMON** | Memory Monitor  | Collects AWR stats and triggers ADDM                     |

Optional Background Processes

| Process  | Full Name                       | Standard Function                                                                    |
| -------- | ------------------------------- | ------------------------------------------------------------------------------------ |
| **ARCn** | Archiver Process                | Copies online redo log files to archive destinations (ARCHIVELOG mode)               |
| **CJQn** | Job Queue Coordinator           | Manages and schedules database jobs                                                  |
| **MMAN** | Memory Manager                  | Dynamically manages and resizes SGA memory (Automatic Memory Management)             |
| **RVWR** | Recovery Writer                 | Writes flashback data to flashback logs (Flashback Database)                         |
| **VKRM** | Virtual Kernel Resource Manager | Manages resource allocation via Oracle Resource Manager (also used in 23ai features) |

#### **Program Global Area (PGA)**

A private memory region for each server process. Not shared. Contains:

- Sort area (ORDER BY, GROUP BY)
- Session-specific information
- Cursor state
- Hash join area

> **Standard rule:** PGA = Process-specific, SGA = Shared across all processes.

### The Database

The database is the physical storage layer on persistent disk. It consists of at least three mandatory file types.
Mandatory Files (required to open the database):

#### Control Files

- `Content:` Database name, timestamp, data file locations, redo log file locations, current log sequence number, checkpoint information.
- `Count:` Minimum 2 (Oracle recommends 3 on separate disks).
- `Size:` Typically 10–100 MB.

#### Data Files

- `Content:` Actual table rows, index blocks, LOBs, undo data (if undo tablespace).
- `Count:` At least 1 (system tablespace).
- `Format:` Oracle proprietary format (not readable by OS directly).

#### Online Redo Log Files

- `Content:` Redo entries recording all changes to the database.
- `Configuration:` Minimum 2 groups (Oracle recommends 3+ groups).
- `Behavior:` Circular writing – when one group fills, Oracle switches to the next.

Optional but Standard Files

| File Type                         | Standard Purpose                                                 |
| --------------------------------- | ---------------------------------------------------------------- |
| **Parameter File (SPFILE/PFILE)** | Stores initialization parameters (memory, processes, file paths) |
| **Password File**                 | Enables remote SYSDBA / SYSOPER authentication                   |
| **Archived Redo Logs**            | Copies of redo logs for media recovery                           |
| **Flashback Logs**                | Supports Flashback Database (point-in-time recovery)             |

The Three Opening Stages (Oracle Startup Stages)

| Stage       | Command              | What Happens                                               | Access           |
| ----------- | -------------------- | ---------------------------------------------------------- | ---------------- |
| **NOMOUNT** | STARTUP NOMOUNT      | Instance starts, SGA allocated, background processes start | No DB access     |
| **MOUNT**   | ALTER DATABASE MOUNT | Control file read, DB associated with instance             | DBA only         |
| **OPEN**    | ALTER DATABASE OPEN  | Datafiles + redo logs opened                               | Full user access |

A standard Oracle instance goes through three phases when starting:

```bash
docker logout container-registry.oracle.com
docker login container-registry.oracle.com # Token `PDZbBJkFDDKLIhtm6v=`
```

```bash
docker run -d \
  --name oracle-xe \
  -p 1521:1521 \
  -e ORACLE_PASSWORD=Sql054003 \
  gvenzl/oracle-xe:21-slim
```

```bash
docker run -d --name oracle-xe \
  -p 1521:1521 \
  -e ORACLE_PASSWORD=Sql054003 \
  gvenzl/oracle-xe:21-slim
```

```bash
curl -I https://container-registry.oracle.com/v2/
```

```bash
docker exec -it oracle-xe sqlplus system/Sql054003@localhost:1521/XEPDB1
```

[Install SQLDeveloper](https://www.oracle.com/database/sqldeveloper/vscode/)

| Setting  | Value     |
| -------- | --------- |
| Host     | localhost |
| Port     | 1521      |
| Service  | XEPDB1    |
| User     | system    |
| Password | Sql054003 |

### CURD Operations

```bash
SELECT username FROM dba_users ORDER BY username;
CREATE USER Jakir IDENTIFIED BY Sql054003;
GRANT CONNECT, RESOURCE TO jakir; # Full developer permissions - Optional
ALTER USER jakir ACCOUNT UNLOCK; # Unlock user if locked
ALTER USER jakir IDENTIFIED BY mypassword; # Reset password
ALTER USER jakir QUOTA UNLIMITED ON users; # Give storage quota
```

```bash
# Login as `system`
docker exec -it oracle-xe sqlplus system/Sql054003@localhost:1521/XEPDB1
GRANT CONNECT, RESOURCE TO jakir; # Full developer permissions - Optional
ALTER USER jakir ACCOUNT UNLOCK; # Unlock user if locked
Exit;
# Login as `jakir`
docker exec -it oracle-xe sqlplus jakir/Sql054003@localhost:1521/XEPDB1
```

```bash
SHOW USER;
SELECT username FROM dba_users; # Show user list
```
