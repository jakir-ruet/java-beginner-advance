### I/O Streams in Java

Java I/O (Input/Output) streams provide a powerful framework for reading data from sources and writing data to destinations. Streams represent a sequence of data flowing between a program and an external source (file, network, memory, etc.).

### Stream Types

1. Byte Streams - Handle raw binary data (8-bit bytes)
   - InputStream (read)
   - OutputStream (write)

#### Byte Stream Hierarchy

```bash
InputStream (abstract)
├── FileInputStream
├── ByteArrayInputStream
├── BufferedInputStream
├── DataInputStream
├── ObjectInputStream
└── SequenceInputStream

OutputStream (abstract)
├── FileOutputStream
├── ByteArrayOutputStream
├── BufferedOutputStream
├── DataOutputStream
├── ObjectOutputStream
└── PrintStream
```

2. Character Streams - Handle text data (16-bit Unicode)
   - Reader (read)
   - Writer (write)

#### Character Stream Hierarchy

```bash
InputStream (abstract)
Reader (abstract)
├── FileReader
├── BufferedReader
├── InputStreamReader
├── StringReader
├── CharArrayReader
└── PipedReader

Writer (abstract)
├── FileWriter
├── BufferedWriter
├── OutputStreamWriter
├── StringWriter
├── CharArrayWriter
└── PrintWriter
```

| Stream Type      | Use Case             |
| ---------------- | -------------------- |
| Byte Stream      | Images, audio, video |
| Character Stream | Text files           |
| Buffered Stream  | Fast file processing |
| Data Stream      | Primitive types      |
| Object Stream    | Java objects         |
