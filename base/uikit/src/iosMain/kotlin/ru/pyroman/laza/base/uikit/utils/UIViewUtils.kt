package ru.pyroman.laza.base.uikit.utils

import platform.UIKit.NSLayoutConstraint
import platform.UIKit.NSLayoutDimension
import platform.UIKit.NSLayoutXAxisAnchor
import platform.UIKit.NSLayoutYAxisAnchor
import platform.UIKit.UIView


enum class PinnedSide {
    top,
    bottom,
    left,
    right,
}

fun UIView.pin(superview: UIView, vararg sides: PinnedSide) {
    translatesAutoresizingMaskIntoConstraints = false
    for (pinnedSide in sides) {
        when (pinnedSide) {
            PinnedSide.top ->
                pinTop(superview)

            PinnedSide.bottom ->
                pinBottom(superview)

            PinnedSide.left ->
                pinLeft(superview)

            PinnedSide.right ->
                pinRight(superview)
        }
    }
}

fun UIView.pin(superview: UIView) {
    pinTop(superview)
    pinLeft(superview)
    pinRight(superview)
    pinBottom(superview)
}

fun UIView.pin(
    superView: UIView,
    sides: Map<PinnedSide, Double>,
) {
    for (side in sides) {
        when (side.key) {
            PinnedSide.top ->
                pinTop(superView, side.value)

            PinnedSide.left ->
                pinLeft(superView, side.value)

            PinnedSide.right ->
                pinRight(superView, side.value)

            PinnedSide.bottom ->
                pinBottom(superView, side.value)
        }
    }
}

fun UIView.pinCenter(superview: UIView) {
    pinCenterX(superview)
    pinCenterY(superview)
}

fun UIView.pinCenterX(superview: UIView): NSLayoutConstraint {
    return makeConstraint {
        centerXAnchor.constraintEqualToAnchor(superview.centerXAnchor)
    }
}

fun UIView.pinCenterY(superview: UIView): NSLayoutConstraint {
    return makeConstraint {
        centerYAnchor.constraintEqualToAnchor(superview.centerYAnchor)
    }
}

fun UIView.pinLeft(
    superview: UIView,
    const: Double = 0.0,
): NSLayoutConstraint {
    return pinLeftEqualTo(superview.leftAnchor, const)
}

fun UIView.pinLeftEqualTo(
    side: NSLayoutXAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        leftAnchor.constraintEqualToAnchor(
            anchor = side,
            constant = const,
        )
    }
}

fun UIView.pinLeftLessThanOrEqualTo(
    side: NSLayoutXAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        leftAnchor.constraintLessThanOrEqualToAnchor(
            anchor = side,
            constant = const,
        )
    }
}

fun UIView.pinRight(
    superview: UIView,
    const: Double = 0.0,
): NSLayoutConstraint {
    return pinRightEqualTo(superview.rightAnchor, const)
}

fun UIView.pinRightEqualTo(
    side: NSLayoutXAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        rightAnchor.constraintEqualToAnchor(
            anchor = side,
            constant = const * -1,
        )
    }
}

fun UIView.pinRightLessThanOrEqualTo(
    side: NSLayoutXAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        rightAnchor.constraintLessThanOrEqualToAnchor(
            anchor = side,
            constant = const * -1,
        )
    }
}

fun UIView.pinTop(
    superview: UIView,
    const: Double = 0.0,
): NSLayoutConstraint {
    return pinTopEqualTo(superview.topAnchor, const)
}

fun UIView.pinTopEqualTo(
    side: NSLayoutYAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        topAnchor.constraintEqualToAnchor(
            anchor = side,
            constant = const,
        )
    }
}

fun UIView.pinTopLessThanOrEqualTo(
    side: NSLayoutYAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        topAnchor.constraintLessThanOrEqualToAnchor(
            anchor = side,
            constant = const,
        )
    }
}

fun UIView.pinBottom(
    superview: UIView,
    const: Double = 0.0,
): NSLayoutConstraint {
    return pinBottomEqualTo(superview.bottomAnchor, const)
}

fun UIView.pinBottomEqualTo(
    side: NSLayoutYAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        bottomAnchor.constraintEqualToAnchor(
            anchor = side,
            constant = const * -1
        )
    }
}

fun UIView.pinBottomLessThanOrEqualTo(
    side: NSLayoutYAxisAnchor,
    const: Double = 0.0,
): NSLayoutConstraint {
    return makeConstraint {
        bottomAnchor.constraintLessThanOrEqualToAnchor(
            anchor = side,
            constant = const * -1,
        )
    }
}

fun UIView.pinHeight(superview: UIView): NSLayoutConstraint {
    return pinHeight(superview.heightAnchor)
}

fun UIView.pinHeight(side: NSLayoutDimension): NSLayoutConstraint {
    return makeConstraint {
        heightAnchor.constraintEqualToAnchor(side)
    }
}

fun UIView.pinHeight(constant: Double): NSLayoutConstraint {
    return makeConstraint {
        heightAnchor.constraintEqualToConstant(constant)
    }
}

fun UIView.pinWidth(superview: UIView): NSLayoutConstraint {
    return pinWidth(superview.widthAnchor)
}

fun UIView.pinWidth(side: NSLayoutDimension): NSLayoutConstraint {
    return makeConstraint {
        widthAnchor.constraintEqualToAnchor(side)
    }
}

fun UIView.pinWidth(constant: Double): NSLayoutConstraint {
    return makeConstraint {
        widthAnchor.constraintEqualToConstant(constant)
    }
}


fun UIView.setHeight(height: Double): NSLayoutConstraint {
    val constraint = heightAnchor.constraintEqualToConstant(height)
    constraint.setActive(true)
    return constraint
}

fun UIView.setWidth(width: Double): NSLayoutConstraint {
    val constraint = widthAnchor.constraintEqualToConstant(width)
    constraint.setActive(true)
    return constraint
}

private fun UIView.makeConstraint(
    constraintInit: () -> NSLayoutConstraint
): NSLayoutConstraint {
    translatesAutoresizingMaskIntoConstraints = false
    val constraint = constraintInit()
    constraint.setActive(true)
    return constraint
}

