## rsyocto GmbH & Co. KG * Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.7 for Intel (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.7 for Intel (ALTERA) SoC-FPGAs" 

LINUX_VERSION ?= "6.7"

# NOTE:  Fri Dec 1 09:59:21 2023 +0800
SRCREV = "408da433dde2bba975b6a020f0841eaa7db419df"
SRCREV:machine:cyclone5 ?= "408da433dde2bba975b6a020f0841eaa7db419df"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

