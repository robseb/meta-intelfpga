## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.10.100 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.10.100 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.10.100"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Tue Jul 26 10:33:11 2022 +0000
SRCREV = "e6ee8aa50bee0d3683885159e5e4b30d23a2ac93"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc   "
SRC_URI:append_arria10 = " file://lbdaf.scc "
