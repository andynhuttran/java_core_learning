package com.javalearning.multithread.folk_join;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

public class CalculateFileRecursiveAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3709531531469244070L;
	
	private AtomicLong atomicLong;
	private File file;
	
	public CalculateFileRecursiveAction(String filepath, AtomicLong atomicLong){
		this(new File(filepath), atomicLong);
	}
	
	public CalculateFileRecursiveAction(File file, AtomicLong atomicLong){
		this.file = Objects.requireNonNull(file);
		this.atomicLong = Objects.requireNonNull(atomicLong);
	}
	
	@Override
	protected void compute() {
		
		if (file.isFile()){
			atomicLong.addAndGet(file.length());
		}
		else { //file is directory
			for (File subFile : file.listFiles()){
				
				CalculateFileRecursiveAction task = new CalculateFileRecursiveAction(subFile, atomicLong);
				ForkJoinTask.invokeAll(task); //call to active compute function in task object
				
			}
		}
		
	}

	
	
}
