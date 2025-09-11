#!/bin/bash

# Custom script to run the Cyclone V emulator with runqemu
# Created by GitHub Copilot

# Source environment
cd /home/vm/poky
source oe-init-build-env

# Set QB_ variables to override machine config
export QB_NETWORK_DEVICE="-device virtio-net-device,netdev=net1 -netdev user,id=net1"
export QB_ROOTFS_OPT="-drive id=disk0,file=@ROOTFS@,if=none,format=raw -device virtio-blk-device,drive=disk0"
export QB_OPT_APPEND="--no-reboot -serial mon:stdio"

# Run QEMU via runqemu
runqemu cyclone5-emulator nographic