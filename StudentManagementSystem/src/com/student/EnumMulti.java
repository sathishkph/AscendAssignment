package com.student;

import java.io.Closeable;
import java.io.IOException;

public enum EnumMulti implements Closeable  {
	
	START(1){
		
		@Override
		public String toString(){
			return "START implementation. Priority="+getPriority();
		}

		@Override
		public String getDetail() {
			return "START";
		}

		@Override
		public void close() throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected String getPriority() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	};

	protected abstract String getPriority();

	public String getDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
