## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 5.10.60 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 5.10.60 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "5.10.60"
LINUX_VERSION_SUFFIX = "-lts"

# Note: Sat Apr 30 03:58:44 2022 +000
SRCREV = "7ee168fb6f6ac0ded3a71c96aaa0036543fe08f8"
SRCREV:machine:cyclone5 ?= "7ee168fb6f6ac0ded3a71c96aaa0036543fe08f8"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

