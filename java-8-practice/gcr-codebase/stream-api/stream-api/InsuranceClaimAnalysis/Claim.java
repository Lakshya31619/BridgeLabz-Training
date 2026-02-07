class Claim {
    private String claimId;
    private String claimType;
    private double claimAmount;
    public Claim(String claimId, String claimType, double claimAmount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }
    public String getClaimType() {
        return claimType;
    }
    public double getClaimAmount() {
        return claimAmount;
    }
}