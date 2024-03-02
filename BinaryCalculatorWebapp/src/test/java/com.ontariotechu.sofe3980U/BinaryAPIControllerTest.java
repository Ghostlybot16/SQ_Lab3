package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    //ADD

    /**
     * Test the ADD functions with two binary numbers of the same length
     */
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void addJson() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /**
     * Test the ADD functions with two binary numbers, the length of the first argument is greater than the length of the second argument
     */
    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("1101"));
    }

    @Test
    public void addJson2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /**
     * Test the ADD function with two binary numbers, the length of the first argument is less than the length of the second
     */
    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1101"));
    }

    @Test
    public void addJson3() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /**
     * Test the ADD function with a binary number and zero
     */
    @Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1010"));
    }
    @Test
    public void addJson4() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
    /**
     * Test the ADD function with 2 zeroes
     */
    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void addJson5() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    //---------------------------------------------------------------------------------------------------------

    //AND
    /**
     * Test the AND function with two binary numbers of the same length
     */
    @Test
    public void and() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(content().string("1000"));
    }
    @Test
    public void andJson() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /**
     * Test the AND functions with two binary numbers of which the length of the first argument is greater than the lenght of the second argument
     */
    @Test
    public void and2() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void andJson2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /**
     * Test the AND function with two binary numbers of which the lenght of the second argument is greater than the length of the first argument
     */
    @Test
    public void and3() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void andJson3() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }
    /**
     * Test the AND function with a binary number and zero
     */
    @Test
    public void and4() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void andJson4() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }
    /**
     * Test the AND function with two zeroes
     */
    @Test
    public void and5() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void andJson5() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    //---------------------------------------------------------------------------------------------------------------
    //OR
    /**
     * Test the OR function with two binary numbers of the same length
     */
    @Test
    public void or() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
    @Test
    public void orJson() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    /**
     * Test the OR function with two binary numbers of which the length of the first argument is greater than the second argument
     */
    @Test
    public void or2() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("1011"));
    }
    @Test
    public void orJson2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
    /**
     * Test the OR function with two binary numbers of which the lenght of the second argument is greater than the first argument
     */
    @Test
    public void or3() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1011"));
    }
    @Test
    public void orJson3() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
    /**
     * Test the OR function with a binary number with zero
     */
    @Test
    public void or4() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1010"));
    }
    @Test
    public void orJson4() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
    /**
     * Test the OR function with two zeroes
     */
    @Test
    public void or5() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void orJson5() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    //-----------------------------------------------------------------------------------------------------------------
    // MULTIPLY
    /**
     * Test the MULTIPLY function with two binary numbers of the same length
     */
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111000"));
    }
    @Test
    public void multiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1000").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    /**
     * Test the MULTIPLY function with two binary numbers of which the length of the first argument is more than the second
     */
    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("11110"));
    }
    @Test
    public void multiplyJson2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1010").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    /**
     * Test the MULTIPLY function with two binary numbers of which the lenght of the second argument more than the first
     */
    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("11110"));
    }
    @Test
    public void multiplyJson3() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "11").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    /**
     * Test the MULTIPLY function with a binary number with zero
     */
    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void multiplyJson4() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    /**
     * Test the MULTIPLY functions with two zeroes
     */
    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
    @Test
    public void multiplyJson5() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
}