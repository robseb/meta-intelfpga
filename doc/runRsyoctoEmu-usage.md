# runRsyoctoEmu.py - Yocto Project QEMU Emulator Guide

## Overview

The `runRsyoctoEmu.py` script is a comprehensive QEMU emulation solution for Yocto Project builds, featuring XML-based configuration, device selection, and export functionality for portable emulator packages.

## Features

### ✅ Implemented Features
- **XML-based Configuration**: Centralized configuration through `rsyocto-emulator.xml`
- **Device Detection & Selection**: Automatic scanning and interactive device selection
- **Multi-device Support**: Support for multiple machine types with creation/update dates
- **Export Functionality**: Creates portable tar.gz packages with all boot components
- **Rootfs Size Reduction**: Configurable rootfs size reduction for exports
- **Portable Boot Scripts**: Generated shell and Python scripts for any Linux computer
- **KVM/TCG Support**: Configurable acceleration (hardware vs software emulation)
- **Port Forwarding**: Configurable SSH, HTTP, and custom port forwarding
- **Documentation Generation**: Automatic README creation for exported packages

## Installation & Setup

1. **Prerequisites**:
   ```bash
   # Ensure you have Python 3 and QEMU installed
   sudo apt-get install python3 qemu-system-arm
   ```

2. **Script Location**: 
   ```bash
   # Script should be in your Yocto project root directory
   /home/vm/poky/runRsyoctoEmu.py
   ```

3. **Configuration File**:
   ```bash
   # Default configuration file
   /home/vm/poky/rsyocto-emulator.xml
   ```

## Usage Examples

### 1. Create Default Configuration
```bash
python3 runRsyoctoEmu.py --create-config
```

### 2. List Available Devices
```bash
python3 runRsyoctoEmu.py --list
```

### 3. Run Specific Device
```bash
python3 runRsyoctoEmu.py -d cyclone5-emulator
```

### 4. Export Portable Package
```bash
# Export with default name
python3 runRsyoctoEmu.py -d cyclone5-emulator -e

# Export with custom name
python3 runRsyoctoEmu.py -d cyclone5-emulator -e my-emulator-package
```

### 5. Use Custom Configuration
```bash
python3 runRsyoctoEmu.py -c my-custom-config.xml -d cyclone5-emulator
```

## Configuration File (rsyocto-emulator.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<rsyocto_emulator>
    <!-- Global settings -->
    <settings memory="2G" acceleration="tcg" export_rootfs_size="1G"/>
    
    <!-- Port forwarding configuration -->
    <port_forwarding>
        <port guest="22" host="2222" description="SSH"/>
        <port guest="80" host="8080" description="HTTP"/>
        <port guest="8000" host="8000" description="Django/Web Server"/>
    </port_forwarding>
    
    <!-- Device definitions -->
    <devices>
        <device name="cyclone5-emulator" 
                machine="virt" 
                description="Intel/Altera Cyclone V SoC FPGA Emulator"
                cpu="cortex-a15"
                memory="2G"
                acceleration="tcg"
                network="user"
                console="ttyAMA0"
                kernel_args="root=/dev/vda rw ip=dhcp console=ttyAMA0,115200 earlycon=pl011,0x9000000"/>
    </devices>
</rsyocto_emulator>
```

## Export Package Structure

When you export a device, the script creates a portable package with:

```
cyclone5-emulator-emulator/
├── README.md                  # Usage instructions
├── emulator-config.xml       # Device configuration
├── rootfs-emulator.ext4      # Root filesystem (size-reduced)
├── run-emulator.py          # Python runner script
├── run-emulator.sh          # Bash boot script
└── zImage-emulator          # Kernel image
```

## Running Exported Packages

### On the Target Computer:

1. **Extract the package**:
   ```bash
   tar -xzf cyclone5-emulator-export.tar.gz
   cd cyclone5-emulator-emulator/
   ```

2. **Run with shell script**:
   ```bash
   ./run-emulator.sh
   ```

3. **Or run with Python script**:
   ```bash
   python3 run-emulator.py
   ```

## Advanced Configuration

### KVM vs TCG Acceleration

- **KVM** (Hardware acceleration): Faster, requires KVM support
- **TCG** (Software emulation): Slower but works everywhere, including nested VMs

```xml
<!-- In device configuration -->
<device name="my-device" acceleration="kvm" ... />
<!-- or -->
<device name="my-device" acceleration="tcg" ... />
```

### Custom Port Forwarding

```xml
<port_forwarding>
    <port guest="22" host="2222" description="SSH"/>
    <port guest="80" host="8080" description="HTTP"/>
    <port guest="443" host="8443" description="HTTPS"/>
    <port guest="3000" host="3000" description="Node.js App"/>
</port_forwarding>
```

### Memory Configuration

```xml
<!-- Global default -->
<settings memory="2G" ... />

<!-- Per-device override -->
<device name="my-device" memory="4G" ... />
```

## Command Line Options

```
usage: runRsyoctoEmu.py [-h] [-c CONFIG] [-d DEVICE] [-e [EXPORT]] [-l] [--create-config]

Options:
  -h, --help                  Show help message
  -c CONFIG, --config CONFIG  XML configuration file path
  -d DEVICE, --device DEVICE  Device name to run
  -e [EXPORT], --export [EXPORT]  Export device package (optional name)
  -l, --list                  List available devices
  --create-config            Create default configuration file
```

## Integration with Yocto Project

### Supported Machines
- **cyclone5-emulator**: Intel/Altera Cyclone V SoC FPGA Emulator
- **cyclone5**: Intel/Altera Cyclone V SoC FPGA  
- **qemuarm**: QEMU ARM Generic

### Build Integration
The script automatically detects built images in:
```
build/tmp/deploy/images/{MACHINE}/
```

### Required Files
- Kernel: `zImage`
- RootFS: `core-image-minimal-{MACHINE}.rootfs.ext4`

## Troubleshooting

### No Console Output
- Verify kernel includes PL011 serial driver
- Check console kernel arguments in configuration
- Ensure correct machine type (virt for cyclone5-emulator)

### QEMU Machine Not Found
- Check machine type in XML configuration
- Verify QEMU supports the specified machine type
- Use `qemu-system-arm -machine help` to list available machines

### Export Package Issues
- Ensure sufficient disk space for rootfs processing
- Check file permissions on export directory
- Verify all required files exist in deploy directory

## Performance Tips

1. **Use KVM when possible** for better performance
2. **Reduce export rootfs size** to minimize package size
3. **Adjust memory allocation** based on your applications
4. **Use port forwarding** instead of bridge networking for simplicity

## File Locations

- Main Script: `/home/vm/poky/runRsyoctoEmu.py`
- Configuration: `/home/vm/poky/rsyocto-emulator.xml`
- Documentation: `/home/vm/poky/meta-intelfpga/doc/`
- Build Images: `/home/vm/poky/build/tmp/deploy/images/`

## Support

For issues or questions:
1. Check this documentation
2. Review the XML configuration
3. Examine the generated QEMU command line
4. Test with minimal configuration first