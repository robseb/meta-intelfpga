## Robin Sebastian (rsyocto GmbH & Co. KG) (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.10.70 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.10.70 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.10.70"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Date:   Fri Dec 10 11:32:26 2021 +0800
SRCREV = "dcd92725a9dd0286b8df631b5f4c941c0a1495f5"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

