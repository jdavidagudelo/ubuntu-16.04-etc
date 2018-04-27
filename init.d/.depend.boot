TARGETS = console-setup resolvconf mountkernfs.sh alsa-utils ufw x11-common pppd-dns hostname.sh apparmor plymouth-log udev keyboard-setup mountdevsubfs.sh procps networking hwclock.sh checkroot.sh urandom mountall.sh checkfs.sh checkroot-bootclean.sh bootmisc.sh mountnfs.sh mountnfs-bootclean.sh kmod mountall-bootclean.sh
INTERACTIVE = console-setup udev keyboard-setup checkroot.sh checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
mountdevsubfs.sh: mountkernfs.sh udev
procps: mountkernfs.sh udev
networking: resolvconf mountkernfs.sh urandom procps
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh keyboard-setup mountdevsubfs.sh hostname.sh
urandom: hwclock.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
checkfs.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
bootmisc.sh: checkroot-bootclean.sh mountnfs-bootclean.sh udev mountall-bootclean.sh
mountnfs.sh: networking
mountnfs-bootclean.sh: mountnfs.sh
kmod: checkroot.sh
mountall-bootclean.sh: mountall.sh
