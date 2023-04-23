## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.15.70 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.15.70 LTS for Intel PSG (ALTERA) SoC-FPGAs" 


LINUX_VERSION = "5.15.70"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Sat Aug 7 00:04:18 2021 +0900
SRCREV = "4a7814a4e2140945fff9d18c02794ae7dea801e8"
SRCREV:machine:cyclone5 ?= "4a7814a4e2140945fff9d18c02794ae7dea801e8"
include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "

