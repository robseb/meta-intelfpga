## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.1.20 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.1.20 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "6.1.20"
LINUX_VERSION_SUFFIX = "-lts"

# Note:  Fri Nov 17 08:13:36 2023 -0500
SRCREV = "8e6bc0b2e3e3abb74576995d8014650a992040b5"
SRCREV:machine:cyclone5 ?= "8e6bc0b2e3e3abb74576995d8014650a992040b5"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"