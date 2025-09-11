## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023
## Updated for Intel FPGA multi-machine and QEMU emulator support

SUMMARY = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel for Intel PSG (ALTERA) SoC-FPGAs" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# Use the correct Intel FPGA repository (altera-fpga organization)
KERNEL_REPO ?= "git://github.com/altera-fpga/linux-socfpga.git"
KERNEL_PROT ?= "https"

require recipes-kernel/linux/linux-yocto.inc

inherit kernel

DEPENDS += "bc-native"

KBRANCH = "${LINUX_VERSION_PREFIX}${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

# Default SRC_URI - can be overridden by individual recipes
SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KBRANCH} \
            file://socfpga_defconfig \
            file://disable-altvipfb.cfg"

# Set source directory properly for kernel builds
S = "${WORKDIR}/git"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Kernel CONFIG_LOCALVERSION
LINUX_VERSION_EXTENSION ?= "-altera" 

# Build branch name
LINUX_VERSION_PREFIX ?= "socfpga-"
LINUX_VERSION_SUFFIX ?= ""

# Kernel image type - ARM64 machines use Image, ARM32 use zImage
KERNEL_IMAGETYPE = "zImage"
KERNEL_IMAGETYPE:aarch64 = "Image"

# Machine recommendations
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules "
MACHINE_FEATURES = "kernel26"
 
# Default to fixed SRCREV (set by individual recipes)
# Removed AUTOREV to ensure reproducible builds
PV = "${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

# Default defconfig settings - can be overridden by individual recipes
KERNEL_DEFCONFIG = "${THISDIR}/files/socfpga_defconfig"

# Machine-specific defconfig overrides
KERNEL_DEFCONFIG:cyclone5 = "${THISDIR}/files/socfpga_defconfig"
KERNEL_DEFCONFIG:cyclone5-emulator = "${THISDIR}/files/socfpga_defconfig" 
KERNEL_DEFCONFIG:arria10 = "${THISDIR}/files/socfpga_defconfig"
KERNEL_DEFCONFIG:arria10-emulator = "${THISDIR}/files/socfpga_defconfig"
KERNEL_DEFCONFIG:agilex3 = "${THISDIR}/files/agilex3_defconfig"
KERNEL_DEFCONFIG:agilex3-emulator = "${THISDIR}/files/agilex3_qemu_virt_defconfig"
KERNEL_DEFCONFIG:agilex5 = "${THISDIR}/files/agilex5_defconfig"
KERNEL_DEFCONFIG:agilex5-emulator = "${THISDIR}/files/agilex5_qemu_virt_defconfig"
KERNEL_DEFCONFIG:stratix10 = "${THISDIR}/files/stratix10_defconfig"
KERNEL_DEFCONFIG:stratix10-emulator = "${THISDIR}/files/stratix10_qemu_virt_defconfig"
