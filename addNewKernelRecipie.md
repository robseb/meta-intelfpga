# Add a Bitbake recipe file to support a new Linux Kernel release



1. **Clone the Linux Kernel to the developer machine**
    ````bash
    git clone https://github.com/altera-opensource/linux-socfpga.git
    ````
2. **Find and checkout the branch with the right Linux Kernel version**
    * List all branches
    ````bash
    git branch -a
    ```` 
    * Checkout the new branch
    ````bash
    git checkout <branch name shown on -a>
    ````
3. **Find the `SRCREV` of the last git commit**
    ````bash
    git log
    ````
4. **Copy&Paste a old Bitbake recipe Kernel file**
5. **Change following:**
    1. `LINUX_VERSION` with the new Linux Kernel Version name
    2. `SRCREV` with the new `SRCREV` of the branch
    3. `LIC_FILES_CHKSUM` with the new Licence file checksum