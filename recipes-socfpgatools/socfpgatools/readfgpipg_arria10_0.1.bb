# Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Read GPI (general purpose input) register of the Intel FPGA Manager"
DESCRIPTION = "Tool to read via the Intel FPGA Manager the GPI (general purpose input) register that can be written by the FPGA" 
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

S = "${WORKDIR}/git/FPGA-gpiRead"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-gpiRead ${D}${bindir}
}
