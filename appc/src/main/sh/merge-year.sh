#!/bin/bash
dir="raw"
if [ ! -e $dir -o ! -d $dir ]
then
  mkdir $dir
fi

for file in `ls`
do
  if [ -d $file -a $file != $dir ]
  then
    for subfile in `ls $file`
    do
      if [[ $subfile == *.gz ]]
      then
        echo "find gzip file $subfile"
        filename="${dir}/${file}.txt"
        `gzip -d -c ${file}/${subfile} >> $filename 2>>error.log`
      fi
    done
  fi
done
