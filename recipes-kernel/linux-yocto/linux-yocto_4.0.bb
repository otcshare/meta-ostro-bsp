KBRANCH ?= "linux-4.0.y"

require recipes-kernel/linux/linux-yocto.inc

S = "${WORKDIR}/linux-stable"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "quark|atom|atomup"

SRCREV = "391b01b08db659e3a4e873f95f63b848f945d257"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=${KBRANCH}"

SRC_URI_append_quark = " \
	file://quark/PATCHv6-1-1-thermal-intel-Quark-SoC-X1000-DTS-thermal-driver.patch \
	file://quark/v4-1-2-firmware_loader-introduce-new-API---request_firmware_direct_full_path.patch \
	file://quark/v4-2-2-efi-an-sysfs-interface-for-user-to-update-efi-firmware.patch \
	file://quark/defconfig \
	"
SRC_URI_append_atom = " \
	file://atom/defconfig"
SRC_URI_append_atomup = " \
	file://atomup/defconfig"

LINUX_VERSION ?= "4.0.9"

