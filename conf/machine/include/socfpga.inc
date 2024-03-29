SOC_FAMILY = "socfpga"


require conf/machine/include/arm/armv7a/tune-cortexa9.inc
# this variable specifies the kernel to be built: linux-altera or linux-altera-ltsi
# this affects the PREFERRED_PROVIDER of virtual/kernel
# it can be overriden from the environment, using BB_ENV_EXTRAWHITE
KERNEL_PROVIDER ?= "linux-altera"
PREFERRED_PROVIDER_virtual/kernel ?= "${KERNEL_PROVIDER}"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

KERNEL_IMAGETYPE ?= "zImage"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules"
MACHINE_FEATURES = "kernel26"

#KBUILD_DEFCONFIG ?= "socfpga_defconfig"

# file system images required
IMAGE_FSTYPES ?= "tar.gz"
