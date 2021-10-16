## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2021

SUMMARY = "Linux Kernel 5.10.60 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.10.60 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.10.60"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Sat Aug 7 00:04:18 2021 +0900
SRCREV = "c35d63f9c7e450605ef20834d2613f845f0c3388"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

