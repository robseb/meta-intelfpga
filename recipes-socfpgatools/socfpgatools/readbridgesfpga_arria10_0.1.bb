# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Read all Intel SoC-FPGA AXI Bridges (lw2fpga; hps2fpga bridge)"
DESCRIPTION = "Tool to write to all Intel SoC-FPGA AXI Bridges (Lightweight HPS-to-FPGA- and HPS-to-FPGA-Bridge) and the MPU Memory space"  

SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsA10.git;protocol=https"
SRCREV = "${AUTOREV}" 
# use  git rev-parse HEAD to update

# This Version is for the Intel Arria 10 SoC-FPGA
COMPATIBLE_MACHINE = 'arria10'

inherit cmake

S = "${WORKDIR}/git/FPGA-readBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-readBridge ${D}${bindir}
}
