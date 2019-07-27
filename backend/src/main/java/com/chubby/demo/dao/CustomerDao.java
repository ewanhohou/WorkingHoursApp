package com.chubby.demo.dao;

import com.chubby.demo.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface CustomerDao {

    @Select("SELECT * FROM customer")
    List<Customer> findAll();

    @Select("SELECT * FROM customer WHERE cus_id = #{cusId}")
    Optional<Customer> findById(long cusId);

    @Insert("INSERT INTO customer (name, mobile, address) VALUES(#{name}, #{mobile}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "cusId")
    long insert(Customer customer);

    @Update("UPDATE customer SET name=#{name}, mobile=#{mobile}, address=#{address} WHERE cus_id =#{cusId}")
    void update(Customer customer);

    @Delete("DELETE FROM customer WHERE cus_id =#{cusId}")
    void delete(Long id);

}