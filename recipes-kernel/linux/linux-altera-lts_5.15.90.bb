## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.15.90 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.15.90 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.15.90"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Thu Feb 16 17:08:54 2023 +0800
SRCREV = "6d869e8d3cd80cbcc935fc21bd85289c3d4477cc"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "

