package net.thoughtforge.bean;

import java.math.BigDecimal;

import net.thoughtforge.aspect.Loggable;
import net.thoughtforge.logger.LogLevel;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Component(value = "simpleBeanSubclass")
public class SimpleBeanSubclass extends SimpleBean {

	private BigDecimal decimalProperty;

	@Loggable(value = LogLevel.TRACE)
	public BigDecimal getDecimalProperty() {
		return decimalProperty;
	}

	@Loggable(value = LogLevel.TRACE)
	public void setDecimalProperty(final BigDecimal decimalProperty) {
		this.decimalProperty = decimalProperty;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("decimalProperty",
				decimalProperty).appendSuper(super.toString()).toString();
	}
}
