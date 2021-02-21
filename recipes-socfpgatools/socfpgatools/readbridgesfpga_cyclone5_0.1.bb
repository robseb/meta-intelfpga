# Robin Sebastian (https://github.com/robseb) 2019-2020

# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Read all Intel SoC-FPGA AXI Bridges (lw2fpga; hps2fpga bridge)"
DESCRIPTION = "Tool to write to all Intel SoC-FPGA AXI Bridges (Lightweight HPS-to-FPGA- and HPS-to-FPGA-Bridge) and the MPU Memory space"  

SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "${AUTOREV}" 
# use  git rev-parse HEAD to update

# This Version is for the Intel Cyclone V SoC-FPGA
COMPATIBLE_MACHINE = 'cyclone5'

inherit cmake

S = "${WORKDIR}/git/FPGA-readBridge"
FILES_${P}N += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-readBridge ${D}${bindir}
}
