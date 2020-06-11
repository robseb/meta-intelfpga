require conf/machine/include/arm/arch-armv8a.inc

KERNEL_PROVIDER ?= "linux-altera"
PREFERRED_PROVIDER_virtual/kernel ?= "${KERNEL_PROVIDER}"
KERNEL_IMAGETYPE = "Image"
MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

KBUILD_DEFCONFIG ?= "defconfig"

IMAGE_FSTYPES ?= "tar.gz"