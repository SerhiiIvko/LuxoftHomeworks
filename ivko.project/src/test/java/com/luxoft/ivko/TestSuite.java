package com.luxoft.ivko;

import com.luxoft.ivko.validator.impl.ClientValidatorServiceImplTest;
import com.luxoft.ivko.validator.impl.ProductValidatorImplTest;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientValidatorServiceImplTest.class,
        ProductValidatorImplTest.class
})
public class TestSuite {
}