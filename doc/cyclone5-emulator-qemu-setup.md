# Cyclone5-Emulator QEMU Setup Guide

## Overview
This document describes the QEMU emulation setup for the cyclone5-emulator machine with configurable KVM/TCG acceleration support.

## KVM/TCG Acceleration Configuration

The `cyclone5-emulator` machine now supports both KVM (hardware acceleration) and TCG (software emulation) modes, configurable through the `local.conf` file.

### Configuration Options

In your `build/conf/local.conf`, set the acceleration mode:

```bash
# For hardware acceleration (faster, requires KVM support)
CYCLONE5_QEMU_ACCEL = "kvm"

# For software emulation (compatible with nested VMs, Proxmox, etc.)
CYCLONE5_QEMU_ACCEL = "tcg"
```

### Default Configuration

By default, the machine is configured to use TCG acceleration for maximum compatibility, especially in nested virtualization environments (Proxmox, QEMU-in-QEMU, etc.).

### Machine Configuration

The machine configuration file `meta-intelfpga/conf/machine/cyclone5-emulator.conf` includes:

- QEMU virt machine support
- ARM Cortex-A15 CPU emulation
- Configurable acceleration through `CYCLONE5_QEMU_ACCEL` variable
- Serial console support (ttyAMA0)
- Virtio block and network device support

### Kernel Configuration

The machine uses `linux-altera-lts` kernel with a custom `qemu_virt_defconfig` that includes:

- QEMU virt machine support
- PL011 serial driver (CONFIG_SERIAL_AMBA_PL011)
- Virtio drivers for block and network devices
- ARM AMBA bus support

## Usage

1. Configure acceleration in `local.conf`:
   ```bash
   CYCLONE5_QEMU_ACCEL = "tcg"  # or "kvm"
   ```

2. Build the image:
   ```bash
   bitbake core-image-minimal
   ```

3. Run with QEMU:
   ```bash
   runqemu nographic slirp serial stdio
   ```

## Current Status

### Working Features
- ✅ Kernel builds with linux-altera-lts
- ✅ QEMU virt machine configuration
- ✅ TCG/KVM acceleration options
- ✅ Proper defconfig selection (qemu_virt_defconfig)
- ✅ QEMU boots without errors

### Known Issues
- ⚠️  Console output not visible (PL011 driver configuration needs investigation)
- ⚠️  Need to verify all kernel config options are properly applied

### Troubleshooting

#### No Console Output
If you don't see console output during boot:

1. Check kernel config for PL011 driver:
   ```bash
   grep CONFIG_SERIAL_AMBA_PL011 tmp/work/cyclone5_emulator-poky-linux-gnueabi/linux-altera-lts/*/linux-*/\.config
   ```

2. Verify QEMU command line includes correct console parameters:
   ```bash
   -append 'console=ttyAMA0,115200 earlycon=pl011,0x9000000'
   ```

#### KVM Not Available
If KVM acceleration fails:
- Switch to TCG mode: `CYCLONE5_QEMU_ACCEL = "tcg"`
- Check if host supports KVM virtualization
- For nested VMs, use TCG mode

## Files Modified

### Machine Configuration
- `meta-intelfpga/conf/machine/cyclone5-emulator.conf`

### Kernel Configuration  
- `meta-intelfpga/recipes-kernel/linux/linux-altera-lts_6.12.19.bbappend`
- `meta-intelfpga/recipes-kernel/linux/files/qemu_virt_defconfig`

### Local Configuration
- `build/conf/local.conf` (user configurable)

## Next Steps

1. Debug and fix console output issue
2. Test with both KVM and TCG acceleration
3. Apply similar configuration to linux-altera kernel
4. Document complete working setup