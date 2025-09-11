#!/bin/bash

# Custom script to run the Cyclone V emulator in QEMU
# Created by GitHub Copilot

# Source environment
cd /home/vm/poky
source oe-init-build-env

# Get paths to needed files
KERNEL_PATH=tmp/deploy/images/cyclone5-emulator/zImage
DTB_PATH=tmp/deploy/images/cyclone5-emulator/cyclone5-emulation.dtb
ROOTFS_PATH=$(ls -1 tmp/deploy/images/cyclone5-emulator/core-image-minimal-cyclone5-emulator.rootfs*.ext4 | head -n1)

# Display paths
echo "Using kernel: $KERNEL_PATH"
echo "Using DTB: $DTB_PATH"
echo "Using rootfs: $ROOTFS_PATH"

# Run QEMU
qemu-system-arm \
  -machine virt,highmem=off \
  -cpu cortex-a15 \
  -m 1G \
  -kernel $KERNEL_PATH \
  -dtb $DTB_PATH \
  -drive if=none,file=$ROOTFS_PATH,format=raw,id=hd0 \
  -device virtio-blk-device,drive=hd0 \
  -netdev user,id=mynet0,hostfwd=tcp::2222-:22 \
  -device virtio-net-device,netdev=mynet0 \
  -nographic \
  -append "console=ttyAMA0 root=/dev/vda rw earlycon debug"