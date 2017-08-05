package com.bt.dao;

import com.bt.domain.PhoneNumber;

import java.util.List;

public interface PhoneNumberDao {
    public List<PhoneNumber> getPhoneNumbers();
    public PhoneNumber getPhoneNumberById(int id);
    public int savePhoneNumber(PhoneNumber u);
    public void persistPhoneNumber(PhoneNumber u);
    public boolean updatePhoneNumber(PhoneNumber u);
    public PhoneNumber mergePhoneNumber(PhoneNumber u);
    public PhoneNumber findPhoneNumberByNumber(String ph);
}
