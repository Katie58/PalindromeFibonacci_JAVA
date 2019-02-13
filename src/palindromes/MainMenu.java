package palindromes;

public enum MainMenu implements MenuInterface{

    STRING{
    	@Override
    	public void execute() {
    		PalindromeUtil.stringPalindrome();
    	}
    },
    INTEGER{
    	@Override
    	public void execute() {
    		PalindromeUtil.intPalindrome();
    	}
    }, 
    FIBONACCI{
    	@Override
    	public void execute() {
    		PalindromeUtil.fibonacci();
    	}
    },
    EXIT{
    	@Override
    	public void execute() {
    		PalindromeApp.exit = true;
    	}  	
    }
}
