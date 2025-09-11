FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Add Agilex 5 device tree and configuration
SRC_URI:append:agilex5 = " \
    file://agilex5.dts \
    file://agilex5_defconfig \
    file://agilex5_dynamiq.cfg \
"

SRC_URI:append:agilex5-emulator = " \
    file://agilex5-emulation.dts \
    file://agilex5_qemu_virt_defconfig \
    file://agilex5_emulator_dynamiq.cfg \
    file://agilex5-clock.h \
"

# Enable device tree compilation
KERNEL_DEVICETREE:agilex5 = "intel/agilex5.dtb"
KERNEL_DEVICETREE:agilex5-emulator = "intel/agilex5-emulation.dtb"

# Override defconfig for agilex5-emulator to use the QEMU version
KERNEL_DEFCONFIG:agilex5-emulator = "${THISDIR}/files/agilex5_qemu_virt_defconfig"

# Simple approach - just copy the files we need during the unpack phase
do_unpack:append:agilex5-emulator() {
    import shutil
    import os
    
    # Ensure directories exist
    intel_dts_dir = os.path.join(d.getVar('S'), 'arch/arm64/boot/dts/intel')
    clock_include_dir = os.path.join(d.getVar('S'), 'include/dt-bindings/clock')
    config_dir = os.path.join(d.getVar('S'), 'arch/arm64/configs')
    
    bb.utils.mkdirhier(intel_dts_dir)
    bb.utils.mkdirhier(clock_include_dir)  
    bb.utils.mkdirhier(config_dir)
    
    workdir = d.getVar('WORKDIR')
    
    # Copy device tree file
    dts_src = os.path.join(workdir, 'agilex5-emulation.dts')
    dts_dst = os.path.join(intel_dts_dir, 'agilex5-emulation.dts')
    if os.path.exists(dts_src):
        shutil.copy2(dts_src, dts_dst)
    
    # Copy clock header
    clock_src = os.path.join(workdir, 'agilex5-clock.h')
    clock_dst = os.path.join(clock_include_dir, 'agilex5-clock.h')  
    if os.path.exists(clock_src):
        shutil.copy2(clock_src, clock_dst)
    
    # Copy defconfig
    defconfig_src = os.path.join(workdir, 'agilex5_qemu_virt_defconfig')
    defconfig_dst = os.path.join(config_dir, 'agilex5_qemu_virt_defconfig')
    if os.path.exists(defconfig_src):
        shutil.copy2(defconfig_src, defconfig_dst)
}

# Note: kernel-devsrc package already provides scripts, so we don't need to install them separately