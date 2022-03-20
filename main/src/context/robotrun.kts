import context.Robot

/**  old version
Robot.operate({
robot ->
    robot.turns(left)
    robot.runs(fast)
    robot.turns(right)

// new version


}) **/

Robot operate {
    it turns left
    it runs fast
    it turns right
}

/*
    We need two context objects, where one will be used as an implicit receiver
    and the other will be used as parameter to the lambda
    that contains the instructions for a robot.
 */
